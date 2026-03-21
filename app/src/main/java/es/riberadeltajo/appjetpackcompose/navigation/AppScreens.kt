package es.riberadeltajo.appjetpackcompose.navigation

sealed class AppScreens(val route: String) {
    object InicioScreen: AppScreens("inicio_screen")
    object RegistroScreen: AppScreens("registro_screen")
    object LoginScreen: AppScreens("login_screen")
    object HistoriaScreen: AppScreens("historia_screen")
    object MiniJuegoScreen: AppScreens("minijuego_screen")
}