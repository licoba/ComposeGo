package com.licoba.composego.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// 导航图，每一个页面都应该在这里登记
@Composable
fun CpGoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = loginNavigationRoute,
        modifier = modifier
    ) {
        loginScreen(
            navigateToHome = { navController.navigateToHome() },
            navigateToRegister = { navController.navigateToRegister() })
        registerScreen(
            navigateToLogin = { navController.navigateToLogin()},
            onNavigateBack = { navController.navigateUp() })
        homeScreen { }
    }
}

