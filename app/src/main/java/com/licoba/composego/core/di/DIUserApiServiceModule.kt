package com.licoba.composego.core.di

import com.licoba.composego.core.network.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 *
 * @author: licoba
 * @date: 2022/4/25
 * 提供UserApi的访问实例
 */

@Module
@InstallIn(SingletonComponent::class)
class DIUserApiServiceModule {

    @Singleton
    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}