package com.licoba.composego.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.licoba.composego.core.repo.UserRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
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
            loginUiState.update { it.copy(isLoading = true) }
            repo.doLogin(loginUiState.value.userName, loginUiState.value.password)
            delay(2000)
            loginUiState.update { it.copy(isLoading = false) }

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