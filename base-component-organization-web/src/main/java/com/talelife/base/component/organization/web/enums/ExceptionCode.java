package com.talelife.base.component.organization.web.enums;

/**
 * 业务异常码
 * @author lwy
 */
public enum ExceptionCode {
	LOGIN_ELSEWHERE(1000,"在其它地方登录"),
	DATA_CANNOT_DELETE(2001,"数据不允许删除"),
	CODE_INVALID(-1000,"编码不正确"),
	TENANT_EXIST(1001,"租户已存在"),
	TENANT_START_FAIL(1002,"租户启用失败"),
	TENANT_STOP_FAIL(1003,"租户停用失败"),
	TENANT_ACCOUNT_PASSWORD_INCORRECT(1004,"租户账号密码不正确"),
	TENANT_UNLOGIN(1005,"认证失败"),
	ORG_NOT_FOUNT(1006,"组织不存在");
	
	private Integer code;
	private String message;
	private ExceptionCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}