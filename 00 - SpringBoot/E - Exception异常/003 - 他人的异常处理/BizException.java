package com.sdyb.util;




/**
 * 自定义异常类
 * 
 * @author 张舜清
 *
 */
@SuppressWarnings("serial")
public class BizException extends RuntimeException {

	private ErrorCode errorCode;

	public BizException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	/**
	 * 可追加自定义Message
	 * 
	 * @param errorCode
	 * @param customMsg
	 */
	public BizException(ErrorCode errorCode, String customMsg) {
		super(customMsg);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}