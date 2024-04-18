package com.example.proj_phase2

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proj_phase2.ui.navigation.AppNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp(navController: NavHostController = rememberNavController()) {
    AppNavHost(navController = navController)
}