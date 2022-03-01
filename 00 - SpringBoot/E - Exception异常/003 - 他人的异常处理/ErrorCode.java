package com.sdyb.util;

/**
 * 错误代码类：我认为0至9999的错误码预留给服务器，10000至19999预留给用户中心模块。其余的模块依次类推 这个类主要定义错误码相关
 *
 * @author 张舜清
 *
 */

public enum ErrorCode {

	BIZ_10000("10000", "缺少参数"),
	BIZ_10001("10001", "参数错误"),
	BIZ_10002("10002", "查找不到数据"),
	BIZ_10003("10003", "数据保存失败"),
	BIZ_10004("10004", "数据记录已存在"),
	BIZ_10005("10005", "数据不能删除"),
	BIZ_10006("10006", "请求返回的内容为空"),
	BIZ_10007("10007", "该用户权限不足"),
	BIZ_10008("10008", "胎次错误"),
	BIZ_10010("10010","发送短信失败"),
	BIZ_10011("10011", "请先登录"),
	BIZ_10012("10012", "数据状态为0"),
	BIZ_10013("10013", "数据状态为1"),
	BIZ_10014("10014", "主绑定人已存在"),
	BIZ_10015("10015", "次数限制"),
	BIZ_10016("10016", "信息输入错误!"),
	BIZ_10017("10017", "用户权限不足!"),
	BIZ_10018("10018", "子线程错误！"),
	BIZ_10019("10019", "主键冲突！"),
	BIZ_10020("10020", "错误的加密信息！"),
	BIZ_10021("10021","数据操作失败"),
	BIZ_10022("10022","验证码错误"),
	ERROR_10023("10023","此用户已建档"),
	ERROR_9999("9999", "服务器系统异常"),
	ERROR_9998("9998", "Token验证失败或过期"),
	ERROR_9997("9997","账号或密码错误"),
	ERROR_9996("9996","账号被锁定,请联系管理员"),
	REQUEST_METHOD_ERROR("9996", "请求方式错误"),
	REQUEST_FORMAT_ERROR("9995", "请求格式错误"),
	ERROR_9980("9980", "拒绝访问!"),
	SUCCESS_0("0","请求成功！");



	private String code;
	private String message;

	ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
