package com.talelife.base.component.organization.web.util;

import com.talelife.base.component.organization.web.enums.ExceptionCode;
import com.talelife.framework.exception.BusinessException;
import com.talelife.framework.exception.ParameterException;

public final class ExceptionUtils {
	private ExceptionUtils(){}
	
	/**
	 * 根据枚举抛业务异常
	 * @param code
	 */
	public static void throwBizException(ExceptionCode code){
		throw new BusinessException(code.getCode(), code.getMessage());
	}
	
	/**
	 * 根据枚举抛参数异常
	 * @param code
	 */
	public static void throwParameterException(ExceptionCode code){
		throw new ParameterException(code.getCode(), code.getMessage());
	}
}
