package com.licoba.composego.core.net.helper

/**
 * 自定义响应异常的抽象类型
 *
 */
interface IResponseException

/**
 * 请求响应异常，主要为各种code码专门定义的异常
 *
 * @param type IResponseCode 异常类型枚举，用于标记该异常的类型
 * @param msg String 异常信息
 * 这个类是规范错误码定义，一般根据后台来，正式项目一般用这个
 *
 */
data class ResponseException(val type: IResponseCode, val msg: String) : Exception(), IResponseException

/**
 * 请求响应异常，主要为各种code码专门定义的异常
 *
 * @param type IResponseCode 异常类型枚举，用于标记该异常的类型
 * @param msg String 异常信息
 * 这个类是规范错误码定义，一般根据后台来
 *
 */
data class ReasonException(val errCode: Int, val errMsg: String) : Exception(), IResponseException

/**
 * 空异常，表示该异常已经被处理过了，不需要再做额外处理了
 *
 */
class ResponseEmptyException : Exception(), IResponseException