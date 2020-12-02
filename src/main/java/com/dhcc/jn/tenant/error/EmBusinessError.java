package com.dhcc.jn.tenant.error;

public enum EmBusinessError implements CommonError {

    //通用错误类型
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    ADD_FAILED_ERROR(10002,"添加系统信息失败"),
    UNKNOWN_ERROR(10003, "未知错误"),
    GET_FAILED_ERROR(10004,"获取系统信息失败"),
    EDIT_FAILED_ERROR(10005,"编辑系统信息失败"),
    ;

    private int errCode;
    private String errMsg;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
