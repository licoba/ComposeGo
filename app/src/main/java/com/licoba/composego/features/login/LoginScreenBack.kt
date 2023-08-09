package com.licoba.composego.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.licoba.composego.R
import com.licoba.composego.core.viewmodel.LoginUiInfo
import com.licoba.composego.core.viewmodel.LoginViewModel
import com.licoba.composego.ui.theme.AppTheme
import com.licoba.composego.ui.widgets.AppButton
import com.licoba.composego.ui.widgets.InputTextField


@Composable
internal fun LoginRouteBack(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit = {}
) {
    val loginUiInfo = viewModel.loginUiInfo.collectAsState().value
    LoginScreen(
        loginUiInfo = loginUiInfo,
        onUserNameChanged = viewModel::onUserNameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        login = viewModel::login,
        navigateToHome = navigateToHome
    )
}

@Composable
fun LoginScreenBack(
    loginUiInfo: LoginUiInfo,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    login: () -> Unit,
    navigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        InputTextField(
            icon =  Icons.Default.AccountBox,
            label = stringResource(R.string.login_user_name),
            text = loginUiInfo.userName
        ) {
            onUserNameChanged(it)
        }
        Spacer(modifier = Modifier.height(10.dp))
        InputTextField(
            icon =  Icons.Default.Lock,
            label = stringResource(R.string.login_password),
            text = loginUiInfo.password) {
            onPasswordChanged(it)
        }
        Spacer(modifier = Modifier.height(20.dp))
        AppButton(text = stringResource(id = com.licoba.composego.R.string.login_do_login)) {
            //TODO call  login()
            login()
//            navigateToHome()
        }

    }

}

@Preview
@Composable
fun LoginPreviewBack() {
    AppTheme {
        LoginScreen(LoginUiInfo("", ""), {}, {}, {}, {})
    }
}