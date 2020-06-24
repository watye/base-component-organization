package com.talelife.base.component.organization.web.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imadcn.framework.idworker.generator.IdGenerator;
import com.talelife.base.component.organization.dao.OrganizationInfoMapper;
import com.talelife.base.component.organization.dao.dto.OrgInfoPath;
import com.talelife.base.component.organization.dao.entity.OrganizationInfo;
import com.talelife.base.component.organization.dao.entity.TenantInfo;
import com.talelife.base.component.organization.web.enums.ExceptionCode;
import com.talelife.base.component.organization.web.service.OrganizationInfoService;
import com.talelife.base.component.organization.web.vo.OrgInfoSort;
import com.talelife.base.component.organization.web.vo.OrgInfoUpdate;
import com.talelife.framework.enums.YesNoEnum;
import com.talelife.framework.mapper.CrudMapper;
import com.talelife.framework.util.BeanUtils;
import com.talelife.framework.util.EntityUtils;
import com.talelife.framework.util.ExceptionUtils;
/**
 * 
 * @author lwy
 *
 */
@Service
public class OrganizationInfoServiceImpl implements OrganizationInfoService {
	/**
	 * 顶级idPath格式
	 */
	private static final String TOP_ID_PATH_FORMAT = "%s,";
	/**
	 * 子级idPath格式
	 */
	private static final String MIDDLE_ID_PATH_FORMAT = "%s%s,";
	@Autowired
	private OrganizationInfoMapper mapper;
	@Autowired
	private IdGenerator idGenerator;
	@Override
	public CrudMapper<OrganizationInfo> getDao() {
		return this.mapper;
	}
	
	@Override
	public boolean save(OrganizationInfo entity) {
		Long parentOrgId = entity.getParentOrgId();
		if(parentOrgId > 0){
			OrganizationInfo parentOrgInfo = getById(parentOrgId);
			entity.setIdPath(String.format(MIDDLE_ID_PATH_FORMAT, parentOrgInfo.getIdPath(),entity.getOrgId()));
			entity.setNamePath(String.format(MIDDLE_ID_PATH_FORMAT, parentOrgInfo.getNamePath(),entity.getOrgName()));
		}else{
			entity.setIdPath(String.format(TOP_ID_PATH_FORMAT, entity.getOrgId()));
			entity.setNamePath(String.format(TOP_ID_PATH_FORMAT, entity.getOrgName()));
		}
		entity.setIsDeleted(YesNoEnum.NO.getValue());
		entity.setMemberCount(0);
		entity.setSort(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
		EntityUtils.setCreateProperty(entity);
		return OrganizationInfoService.super.save(entity);
	}


	@Override
	public void addTopOrgInfo(TenantInfo tenantInfo) {
		OrganizationInfo orgInfo = new OrganizationInfo();
		orgInfo.setOrgId(idGenerator.nextId());
		orgInfo.setTenantId(tenantInfo.getTenantId());
		orgInfo.setOrgName(tenantInfo.getTenantName());
		orgInfo.setIsDeleted(YesNoEnum.NO.getValue());
		orgInfo.setMemberCount(0);
		orgInfo.setIdPath(String.format(TOP_ID_PATH_FORMAT, orgInfo.getOrgId()));
		orgInfo.setNamePath(String.format(TOP_ID_PATH_FORMAT,orgInfo.getOrgName()));
		orgInfo.setSort(0);
		orgInfo.setParentOrgId(0L);
		EntityUtils.setCreateProperty(orgInfo);
		save(orgInfo);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateOrgInfo(OrgInfoUpdate orgInfoUpdate) {
		Long orgId = orgInfoUpdate.getOrgId();
		Objects.requireNonNull(orgId);
		
		OrganizationInfo sourceOrgInfo = getById(orgId);
		if(Objects.isNull(sourceOrgInfo)){
			ExceptionUtils.throwParameterException(ExceptionCode.ORG_NOT_FOUNT.getCode(), ExceptionCode.ORG_NOT_FOUNT.getMessage());
		}
		
		updateCurrentOrgInfo(orgInfoUpdate, sourceOrgInfo);
		
	}

	@Override
	public boolean deleteById(Long id) {
		Objects.requireNonNull(id);
		OrganizationInfo orgInfo = getById(id);
		if(Objects.isNull(orgInfo)){
			ExceptionUtils.throwParameterException(ExceptionCode.ORG_NOT_FOUNT.getCode(), ExceptionCode.ORG_NOT_FOUNT.getMessage());
		}
		
		//叶子组织才允许删除
		if(!mapper.isLeaf(orgInfo.getIdPath())){
			ExceptionUtils.throwParameterException(ExceptionCode.ORG_EXIST_CHILD.getCode(), ExceptionCode.ORG_EXIST_CHILD.getMessage());
		}
		
		//组织下无用户才允许删除
		return OrganizationInfoService.super.deleteById(id);
	}

	@Override
	public void sort(List<OrgInfoSort> orgInfoSorts) {
		Objects.requireNonNull(orgInfoSorts);
		if(!orgInfoSorts.isEmpty()){
			mapper.batchSort(BeanUtils.mapAsList(orgInfoSorts, OrgInfoSort.class, com.talelife.base.component.organization.dao.dto.OrgInfoSort.class));
		}
	}
	
	@Override
	public OrganizationInfo getRootOrgInfo(Long tenantId) {
		OrganizationInfo query = new OrganizationInfo();
		query.setTenantId(tenantId);
		return get(query);
	}

	/**
	 * 更新本组织信息
	 * @param orgInfoUpdate 更新内容
	 * @param sourceOrgInfo 原组织信息
	 */
	private void updateCurrentOrgInfo(OrgInfoUpdate orgInfoUpdate, OrganizationInfo sourceOrgInfo) {
		OrganizationInfo entity = new OrganizationInfo();
		entity.setOrgId(orgInfoUpdate.getOrgId());
		entity.setOrgName(orgInfoUpdate.getOrgName());
		
		Long parentOrgId = orgInfoUpdate.getParentOrgId();
		
		if(havingMoveOrg(sourceOrgInfo, parentOrgId)){
			OrganizationInfo parentOrgInfo = getById(parentOrgId);
			if(Objects.isNull(parentOrgInfo)){
				ExceptionUtils.throwParameterException(ExceptionCode.ORG_NOT_FOUNT.getCode(), ExceptionCode.ORG_NOT_FOUNT.getMessage());
			}
			entity.setParentOrgId(parentOrgId);
			entity.setIdPath(String.format(MIDDLE_ID_PATH_FORMAT, parentOrgInfo.getIdPath(), entity.getOrgId()));
			entity.setNamePath(String.format(MIDDLE_ID_PATH_FORMAT, parentOrgInfo.getNamePath(), entity.getOrgName()));
		}else{
			String[] pathArray = sourceOrgInfo.getNamePath().split(",");
			pathArray[pathArray.length-1] = entity.getOrgName();
			entity.setIdPath(sourceOrgInfo.getIdPath());
			entity.setNamePath(Arrays.asList(pathArray).stream().collect(Collectors.joining(",","",",")));
		}
		
		EntityUtils.setModifyProperty(entity);
		updateById(entity);
		
		updateChilrenOrgPath(new OrgInfoPath(sourceOrgInfo.getIdPath(),sourceOrgInfo.getNamePath(),entity.getIdPath(),entity.getNamePath()));
	}

	/**
	 * 是否移动组织
	 * @param sourceOrgInfo 原组织
	 * @param parentOrgId 修改提交的父节点id
	 * @return 移动true，没移动false
	 */
	private boolean havingMoveOrg(OrganizationInfo sourceOrgInfo, Long parentOrgId) {
		return Objects.nonNull(parentOrgId) && parentOrgId.longValue() != sourceOrgInfo.getParentOrgId().longValue();
	}
	
	/**
	 * 更新子组织路径
	 * @param OrgInfoPath 路径对象
	 */
	private void updateChilrenOrgPath(OrgInfoPath orgInfoPath){
		if(havingMoveOrg(orgInfoPath.getOldIdPath(), orgInfoPath.getNewIdPath())){
			mapper.updateChilrenOrgPath(orgInfoPath);
		}else if(havingRename(orgInfoPath.getOldNamePath(), orgInfoPath.getNewNamePath())){
			mapper.updateChilrenNamePath(orgInfoPath);
		}
	}
	
	/**
	 * 是否移动组织
	 * @param oldIdPath 原路径id
	 * @param newIdPath 新路径id
	 * @return 移动true，没移动false
	 */
	private boolean havingMoveOrg(String oldIdPath, String newIdPath) {
		Objects.requireNonNull(oldIdPath);
		Objects.requireNonNull(newIdPath);
		return !oldIdPath.equals(newIdPath);
	}
	
	/**
	 * 组织是否改名
	 * @param oldNamePath 原路径名称
	 * @param newNamePath 新路径名称
	 * @return 改名true,没改名false
	 */
	private boolean havingRename(String oldNamePath, String newNamePath) {
		Objects.requireNonNull(oldNamePath);
		Objects.requireNonNull(newNamePath);
		return !oldNamePath.equals(newNamePath);
	}
}