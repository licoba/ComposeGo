package com.licoba.composego

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.licoba.composego.features.login.LoginRoute
import com.licoba.composego.ui.navigation.CpGoNavHost
import com.licoba.composego.ui.theme.AppTheme
import com.licoba.composego.utils.logD
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

//        val viewModel: LoginViewModel by

        val TAG = MainActivity::class.simpleName.toString()
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition {
            lifecycleScope.launch { }
            logD("闪屏页消失", TAG)
            false  // false为消失  true为保持
            //return true while fetching data from network
            // when (uiState) {
            //                Loading -> true
            //                is Success -> false
            //            }
        }
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CpGoNavHost(navController = navController)
                }
            }
        }
    }
}


