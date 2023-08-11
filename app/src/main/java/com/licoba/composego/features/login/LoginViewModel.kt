package com.licoba.composego.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.licoba.composego.core.repo.UserRepoImpl
import com.licoba.composego.utils.logE
import com.licoba.composego.utils.showDebugToast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: UserRepoImpl
) : ViewModel() {
    val loginUiState by lazy {
        MutableStateFlow(
            LoginUiState("", "")
        )
    }


    fun login() {
        viewModelScope.launch {
            repo.doLogin(loginUiState.value.userName, loginUiState.value.password).catch {
                logE(it.toString(), "注册错误")
            }
            .onStart {
                loginUiState.value = loginUiState.value.copy(isLoading = true)
            }
            .onCompletion {
                loginUiState.value = loginUiState.value.copy(isLoading = false)
            }
            .collect {
                showDebugToast("登录成功！")
                logE(it.toString(), "登录成功！")
            }
        }
    }

    fun onUserNameChanged(userName: String) {
        loginUiState.value = loginUiState.value.copy(userName = userName)
    }

    fun onPasswordChanged(password: String) {
        loginUiState.value = loginUiState.value.copy(password = password)
    }
}

// 登录相关的UI状态
data class LoginUiState(
    val userName: String,
    val password: String,
    var isLoading: Boolean = false, // 是否正在登录
    val errorStr: String? = null
) {
    fun isFormValid(): Boolean {
        return userName.isNotEmpty() && password.isNotEmpty()
    }
}