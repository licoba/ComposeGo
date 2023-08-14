package com.licoba.composego.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.licoba.composego.features.login.LoginRoute
import com.licoba.composego.features.register.RegisterRoute

// 登录模块的navigation
const val loginNavigationRoute = "login_route"
const val registerNavigationRoute = "register_route"


fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    this.navigate(registerNavigationRoute, navOptions)
}


fun NavGraphBuilder.loginScreen(navigateToHome: () -> Unit, navigateToRegister: () -> Unit) {
    composable(route = loginNavigationRoute) {
        LoginRoute(onNavigateToHome = navigateToHome, onNavigateToRegistration = navigateToRegister)
    }
}
fun NavGraphBuilder.registerScreen(onNavigateBack: () -> Unit, navigateToLogin: () -> Unit) {
    composable(route = registerNavigationRoute) {
        RegisterRoute(onNavigateBack = onNavigateBack )
    }
}