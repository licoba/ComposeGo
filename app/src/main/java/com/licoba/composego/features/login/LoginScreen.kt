package com.licoba.composego.features.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.licoba.composego.R
import com.licoba.composego.core.viewmodel.LoginUiInfo
import com.licoba.composego.core.viewmodel.LoginViewModel
import com.licoba.composego.ui.theme.AppTheme
import com.licoba.composego.ui.theme.dimens
import com.licoba.composego.ui.widgets.AppButton
import com.licoba.composego.ui.widgets.InputTextField
import com.licoba.composego.ui.widgets.MediumTitleText
import com.licoba.composego.ui.widgets.PasswordTextField
import com.licoba.composego.ui.widgets.TitleText


@Composable
internal fun LoginRoute(
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
fun LoginScreen(
    loginUiInfo: LoginUiInfo,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    login: () -> Unit,
    navigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = dimens.paddingLarge)
                    .padding(bottom = dimens.paddingExtraLarge)
            ) {
                MediumTitleText(
                    modifier = Modifier
                        .padding(top = dimens.paddingLarge)
                        .fillMaxWidth(),
                    text = stringResource(id = R.string.jetpack_compose),
                    textAlign = TextAlign.Center
                )

                // Login Logo 使用coil加载
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp)
                        .padding(top = dimens.paddingSmall),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data = R.drawable.jetpack_compose_logo)
                        .crossfade(enable = true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = stringResource(id = R.string.login_do_login)
                )
                // 欢迎
                TitleText(
                    modifier = Modifier.padding(top = 20.dp, bottom = 36.dp),
                    text = stringResource(id = R.string.welcome)
                )
                InputTextField(
                    icon = Icons.Default.AccountBox,
                    label = stringResource(R.string.login_user_name),
                    text = loginUiInfo.userName
                ) {
                    onUserNameChanged(it)
                }
                Spacer(modifier = Modifier.height(10.dp))
                PasswordTextField(
                    label = stringResource(R.string.login_password),
                    value = loginUiInfo.password
                ) {
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


        // Register Section
        Row(
            modifier = Modifier.padding(dimens.paddingNormal),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Don't have an account?
            Text(text = stringResource(id = R.string.do_not_have_account))

            //Register
            Text(
                modifier = Modifier
                    .padding(start = dimens.paddingExtraSmall)
                    .clickable {
                    },
                text = stringResource(id = R.string.register),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    AppTheme {
        LoginScreen(LoginUiInfo("", ""), {}, {}, {}, {})
    }
}