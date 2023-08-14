package com.licoba.composego.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.licoba.composego.features.home.HomeRoute
import com.licoba.composego.features.login.LoginRoute

// 登录模块的navigation
const val homeNavigationRoute = "home_route"


fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

// https://stackoverflow.com/questions/65610003/pass-parcelable-argument-with-compose-navigation
fun NavGraphBuilder.homeScreen(navigateToHome: () -> Unit) {
    composable(route = homeNavigationRoute) {
        HomeRoute(navigateToHome = navigateToHome)
    }
}