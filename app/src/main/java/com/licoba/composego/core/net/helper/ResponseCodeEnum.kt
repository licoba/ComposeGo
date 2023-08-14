package com.licoba.composego.core.net.helper

/**
 * 请求响应code枚举抽象
 *
 */
interface IResponseCode {

    /**
     * 获取该枚举的code码
     * @return Int
     */
    fun getCode(): Int

    /**
     * 获取该枚举的描述
     * @return String
     */
    fun getMessage(): String
}

// Gateway层 业务信息
enum class ReasonCodeEnum(val reasonCode: Int, val reason: String) {


    /**
     * 登录过期.
     */
    LoginExpired(1001, "Login Expired."),


    /**
     * 未捕捉到异常, 建议手机端打印code:reasonCode.
     */
    UnCaughtException(2000, "Un Caught Exception."),

    /**
     * 邮箱为空.
     */
    EmailEmpty(2001, "Email empty."),

    /**
     * 密码为空.
     */
    PassEmpty(2002, "Pass empty."),

    /**
     * 密码错误.
     */
    PassError(2003, "Pass Error."),

    /**
     * 验证码为空.
     */
    VerifyCodeEmpty(2004, "VerifyCode Empty."),

    /**
     * 验证码错误.
     */
    VerifyCodeError(2005, "VerifyCode Error."),

    /**
     * 昵称为空.
     */
    NicknameEmpty(2006, "Nickname Empty."),

    /**
     * 三方唯一标识为空.
     */
    ThirdUniEmpty(2007, "Third Uni Empty."),

    /**
     * 获取/验证验证码时候 optType为空.
     */
    OptTypeEmpty(2008, "OptType Empty."),

    /**
     * 用户邮箱 已注册.
     */
    EmailRegistered(2009, "Email Registered."),

    /**
     * id 为空(用户id, 其他表记录主键id).
     */
    IdEmpty(2010, "Id Empty."),

    /**
     * 头像七牛地址为空.
     */
    AvatarEmpty(2011, "Avatar Empty."),

    /**
     * token为空.
     */
    TokenEmpty(2012, "Token Empty."),

    /**
     * token过期.
     */
    TokenExpired(2013, "Token Expired."),

    /**
     * 验证码过期.
     */
    VerifyCodeExpired(2014, "VerifyCode Expired."),

    /**
     * 发送验证码限制.
     */
    VerifyCodeLimit(2015, "VerifyCode Limit."),

    /**
     * 邮箱超过50字符.
     */
    EmailLengthLimit(2016, "Email Length Limit."),

    /**
     * 邮箱密码登录次数限制.
     */
    EmailPassLoginLimit(2017, "Email Pass Login Limit."),

    /**
     * 邮箱密码登录-锁定.
     */
    EmailPassLoginLock(2018, "Email Pass Login Lock."),

}


//一级响应码
enum class RespCodeEnum(val success: Boolean, val code: Int, val desc: String) {

    Success(true, 200, "Success."),

    ParamMissing(false, 301, "Param Missing."),
    ParamError(false, 302, "Param Error."),

    NoService(false, 401, "No Service."),
    DataNotFound(false, 404, "Data Not Found."),

    InternalError(false, 500, "Internal Error."),
    ThirdError(false, 501, "Third Called Error.");

}
