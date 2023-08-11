package com.licoba.composego.core.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

/**
 * 仓库层 Repository 基类
 *
 * @author licoba
 * @since 2023/08/11
 */
interface BaseRepository {

    /**
     * 发起请求封装
     * 该方法将flow的执行切换至IO线程
     *
     * @param requestBlock 请求的整体逻辑
     * @return Flow<T>
     */
    fun <T> makeRequest(requestBlock: suspend FlowCollector<T>.() -> Unit): Flow<T> {
        return flow(block = requestBlock).flowOn(Dispatchers.IO)
        // 返回，也就是生成一个flow的工作流，运行在IO线程中
        // block 就是传入的代码块，requestBlock必须要在调用collect的时候才会执行，否则flow会立即返回
        // 这几行代码是真的太高级了，够我看一天
        // 知识点：Kotlin泛型，T作为泛型的类型，返回一个泛型的Flow，这里的泛型就是一个UserBean
        // 泛型基本用法：flow { emit(1) }.collect { println(it) }
    }

    suspend fun <T> makeApiCall(
        call: suspend () -> T
    ): Result<T> = runCatching {
        withContext(Dispatchers.IO) {
            call.invoke()
        }
    }

}