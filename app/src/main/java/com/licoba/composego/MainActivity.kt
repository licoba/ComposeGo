package com.licoba.composego

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ToastUtils
import com.licoba.composego.core.viewmodel.LoginViewModel
import com.licoba.composego.features.login.LoginRoute
import com.licoba.composego.features.login.LoginScreen
import com.licoba.composego.ui.theme.AppTheme
import com.licoba.composego.utils.logD
import com.licoba.composego.utils.showDebugToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

//        val viewModel: LoginViewModel by

        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition {
            lifecycleScope.launch {  }
            showDebugToast("闪屏页消失")
            logD("闪屏页消失","很好")
            false  // false为消失  true为保持
            //return true while fetching data from network
            // when (uiState) {
            //                Loading -> true
            //                is Success -> false
            //            }
        }
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginRoute()
                }
            }
        }
    }
}


