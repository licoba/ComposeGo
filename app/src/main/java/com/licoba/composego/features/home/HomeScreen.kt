package com.licoba.composego.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.licoba.composego.ui.theme.AppTheme
import com.licoba.composego.ui.theme.dimens
import com.licoba.composego.ui.widgets.AppButton
import com.licoba.composego.ui.widgets.InputTextField
import com.licoba.composego.ui.widgets.LoadingDialog
import com.licoba.composego.ui.widgets.MediumTitleText
import com.licoba.composego.ui.widgets.PasswordTextField


@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit = {}
) {
    val loginUiInfo = viewModel.loginUiState.collectAsState().value
    HomeScreen(
        loginUiState = loginUiInfo,
        onUserNameChanged = viewModel::onUserNameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        login = viewModel::login,
        navigateToHome = navigateToHome
    )
}

@Composable
fun HomeScreen(
    loginUiState: LoginUiState,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    login: () -> Unit,
    navigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            MediumTitleText(
                modifier = Modifier
                    .padding(top = dimens.paddingLarge)
                    .fillMaxWidth(),
                text = stringResource(id = R.string.jetpack_compose),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    AppTheme {
        HomeScreen(LoginUiState("", ""), {}, {}, {}, {})
    }
}