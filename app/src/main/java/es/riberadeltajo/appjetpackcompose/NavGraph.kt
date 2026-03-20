package es.riberadeltajo.appjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.riberadeltajo.appjetpackcompose.screens.InicioScreen

@Composable
fun NavGraph(navController: NavHostController, userViewModel: UserViewModel) {
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio")    { InicioScreen(navController) }

    }
}
