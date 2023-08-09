package com.licoba.composego.core.repo

import com.licoba.composego.core.network.api.UserApi
import com.licoba.composego.utils.logD
import javax.inject.Inject
import javax.inject.Singleton

// 数据仓库层，可以从net层拿数据，也可以从local拿数据
@Singleton
class UserRepoImpl @Inject constructor(
    private val api: UserApi,
) : UserRepo {
    override suspend fun doLogin(username: String, password: String) {
        val result = api.login(username, password)
        logD("结果：$result")
        logD("结果：${result.body()}")
    }
}
