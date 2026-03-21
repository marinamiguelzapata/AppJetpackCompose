package es.riberadeltajo.appjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.riberadeltajo.appjetpackcompose.UserViewModel
import es.riberadeltajo.appjetpackcompose.screens.HistoriaScreen
import es.riberadeltajo.appjetpackcompose.screens.InicioScreen
import es.riberadeltajo.appjetpackcompose.screens.LoginScreen
import es.riberadeltajo.appjetpackcompose.screens.MiniJuegoScreen
import es.riberadeltajo.appjetpackcompose.screens.RegistroScreen

//componente que orquestará la navegación entre pantallas

@Composable
fun NavGraph(navController: NavHostController, userViewModel: UserViewModel) {
    NavHost(navController = navController, startDestination = AppScreens.InicioScreen.route) {
        //InicioScreen
        composable(route = AppScreens.InicioScreen.route) {
            InicioScreen(navController)
        }

        //RegistroScreen
        composable(route = AppScreens.RegistroScreen.route) {
            RegistroScreen(navController)
        }

        //LoginScreen
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }

        //HistoriaScreen
        composable(route = AppScreens.HistoriaScreen.route) {
            HistoriaScreen(navController)
        }

        //MiniJuegoScreen
        composable(route = AppScreens.MiniJuegoScreen.route) {
            MiniJuegoScreen(navController)
        }

    }
}
