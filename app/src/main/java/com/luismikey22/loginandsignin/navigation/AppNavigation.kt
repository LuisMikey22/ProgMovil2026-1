package com.luismikey22.loginandsignin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luismikey22.loginandsignin.screens.LoginScreen
import com.luismikey22.loginandsignin.screens.MainScreen
import com.luismikey22.loginandsignin.screens.SignInScreen
import com.luismikey22.loginandsignin.screens.WelcomeScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ){
        composable("welcome"){
            WelcomeScreen(navController)
        }
        composable("login"){
            LoginScreen(navController)
        }
        composable("signup"){
            SignInScreen(navController)
        }
        composable("main"){
            MainScreen(navController)
        }
    }
}