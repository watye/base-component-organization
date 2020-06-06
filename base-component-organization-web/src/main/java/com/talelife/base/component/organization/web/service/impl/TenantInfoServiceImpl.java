package com.talelife.base.component.organization.web.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.imadcn.framework.idworker.generator.IdGenerator;
import com.talelife.base.component.organization.dao.TenantInfoMapper;
import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.constant.Constants;
import com.talelife.base.component.organization.web.dto.TenantLoginInfo;
import com.talelife.base.component.organization.web.enums.ExceptionCode;
import com.talelife.base.component.organization.web.service.OrganizationInfoService;
import com.talelife.base.component.organization.web.service.TenantInfoService;
import com.talelife.base.component.organization.web.util.UserContext;
import com.talelife.base.component.organization.web.vo.TenantInfoRegister;
import com.talelife.base.component.organization.web.vo.TenantLoginVO;
import com.talelife.framework.enums.YesNoEnum;
import com.talelife.framework.mapper.CrudMapper;
import com.talelife.framework.util.BeanUtils;
import com.talelife.framework.util.CacheUtils;
import com.talelife.framework.util.EntityUtils;
import com.talelife.framework.util.ExceptionUtils;

@Service
public class TenantInfoServiceImpl implements TenantInfoService {
	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private TenantInfoMapper mapper;
	@Autowired
	private OrganizationInfoService orgInfoService;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;

	@Override
	public CrudMapper<TenantInfo> getDao() {
		return this.mapper;
	}

	@Transactional
	@Override
	public Long register(TenantInfoRegister infoRegister) {
		if(mapper.getCountByUsername(infoRegister.getPhone(), infoRegister.getEmail()) > 0){
			ExceptionUtils.throwBizException(ExceptionCode.TENANT_EXIST.getCode(),ExceptionCode.TENANT_EXIST.getMessage());
		}
		TenantInfo tenantInfo = BeanUtils.map(infoRegister, TenantInfo.class);
		tenantInfo.setTenantId(idGenerator.nextId());
		tenantInfo.setPasswordSalt("1");
		tenantInfo.setLastLoginTime(new Date());
		tenantInfo.setLastLoginIp("");
		EntityUtils.setCreateProperty(tenantInfo);
		mapper.save(tenantInfo);
		
		orgInfoService.addTopOrgInfo(tenantInfo);
		
		return tenantInfo.getTenantId();
	}

	@Override
	public void start(Long tenantId) {
		Objects.requireNonNull(tenantId);
		TenantInfo entity = new TenantInfo();
		entity.setTenantId(tenantId);
		entity.setIsEnable(YesNoEnum.YES.getValue());
		if(mapper.updateById(entity) < 1){
			ExceptionUtils.throwBizException(ExceptionCode.TENANT_START_FAIL.getCode(),ExceptionCode.TENANT_START_FAIL.getMessage());
		}
	}

	@Override
	public void stop(Long tenantId) {
		Objects.requireNonNull(tenantId);
		TenantInfo entity = new TenantInfo();
		entity.setTenantId(tenantId);
		entity.setIsEnable(YesNoEnum.NO.getValue());
		if(mapper.updateById(entity) < 1){
			ExceptionUtils.throwBizException(ExceptionCode.TENANT_STOP_FAIL.getCode(),ExceptionCode.TENANT_STOP_FAIL.getMessage());
		}
	}

	@Override
	public TenantLoginInfo login(TenantLoginVO tenantLoginVO) {
		TenantInfo tenantInfo = mapper.getByAccountPassword(tenantLoginVO.getAccount(), tenantLoginVO.getPassword());
		if(Objects.isNull(tenantInfo)){
			ExceptionUtils.throwParameterException(ExceptionCode.TENANT_ACCOUNT_PASSWORD_INCORRECT.getCode(), ExceptionCode.TENANT_ACCOUNT_PASSWORD_INCORRECT.getMessage());
		}
		updateLastLoginInfo(tenantInfo.getTenantId(),tenantLoginVO.getLastLoginIp());
		
		TenantLoginInfo tenantLoginInfo = BeanUtils.map(tenantInfo, TenantLoginInfo.class);
		tenantLoginInfo.setToken(UUID.randomUUID().toString());
		
		saveLoginInfo(tenantLoginInfo);
		return tenantLoginInfo;
	}

	@Override
	public void updateLastLoginInfo(Long tenantId, String lastLoginIp) {
		TenantInfo tenantInfo = new TenantInfo();
		tenantInfo.setTenantId(tenantId);
		tenantInfo.setLastLoginIp(lastLoginIp);
		tenantInfo.setLastLoginTime(new Date());
		EntityUtils.setModifyProperty(tenantInfo);
	}
	
	
	@Override
	public TenantLoginInfo getLoginInfo(String token) {
		Objects.requireNonNull(token);
		return (TenantLoginInfo) redisTemplate.opsForValue().get(CacheUtils.getCacheKey(Constants.PROJECT_NAME, Constants.TENANT_INFO, token));
	}
	
	@Override
	public String getToken(Long tenantId, String email) {
		Objects.requireNonNull(tenantId);
		Objects.requireNonNull(email);
		return redisTemplate.opsForValue().get(CacheUtils.getCacheKey(Constants.PROJECT_NAME, Constants.TENANT_TOKEN, tenantId+"-"+email)).toString();
	}
	
	private void saveLoginInfo(TenantLoginInfo tenantLoginInfo) {
		UserContext.setLoginInfo(tenantLoginInfo);
		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		ops.set(CacheUtils.getCacheKey(Constants.PROJECT_NAME, Constants.TENANT_INFO,tenantLoginInfo.getToken()), tenantLoginInfo, Constants.TOKEN_EXPIRE_TIME,TimeUnit.MINUTES);
		
		ops.set(CacheUtils.getCacheKey(Constants.PROJECT_NAME, Constants.TENANT_TOKEN,tenantLoginInfo.getTenantId()+"-"+tenantLoginInfo.getEmail()), 
				tenantLoginInfo.getToken(), Constants.TOKEN_EXPIRE_TIME,TimeUnit.MINUTES);
	}
}