package com.licoba.composego.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.licoba.composego.core.repo.UserRepo
import com.licoba.composego.core.repo.UserRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: UserRepoImpl
) : ViewModel() {
     val loginUiInfo by lazy {
        MutableStateFlow(
            LoginUiInfo("", "")
        )
    }

    fun login() {
        viewModelScope.launch {
            repo.doLogin(loginUiInfo.value.userName, loginUiInfo.value.password)
        }
    }

    fun onUserNameChanged(userName: String) {
        loginUiInfo.value = loginUiInfo.value.copy(userName = userName)
    }

    fun onPasswordChanged(password: String) {
        loginUiInfo.value = loginUiInfo.value.copy(password = password)
    }
}


data class LoginUiInfo(
    val userName: String,
    val password: String
)