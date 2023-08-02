package com.licoba.composego.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.licoba.composego.features.login.LoginRoute

const val loginNavigationRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(navigateToHome: () -> Unit) {
    composable(route = loginNavigationRoute) {
        LoginRoute(navigateToHome = navigateToHome)
    }
}