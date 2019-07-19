package com.whut.mall.common.framework.constant;

/**
 * 错误码枚举类
 *
 * 管理员系统，使用 1-002-000-000 段
 */
public enum AdminErrorCodeEnum {

    // ========== 管理员模块 1002002000 ==========
    ADMIN_USERNAME_NOT_REGISTERED(1002002000, "账号不存在"),
    ADMIN_PASSWORD_ERROR(1002002001, "密码不正确"),
    ADMIN_IS_DISABLE(1002002002, "账号被禁用"),
        ;

    private final int code ;
    private final String message;

    AdminErrorCodeEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
