package es.riberadeltajo.appjetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import es.riberadeltajo.appjetpackcompose.ui.theme.Morado_uno

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiniJuegoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Minijuego") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Morado_uno,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) {
        MinijuegoBodyContent(navController)
    }

}

//función para establecer el contenido de la pantalla
@Composable
fun MinijuegoBodyContent(navController: NavController){
    //TODO algo distinto al ejemplo de Alberto
}


////Ejemplo de LaunchedEffect
//LaunchedEffect(contador) {
//    if (contador >= OBJETIVO) {
//        mostrarDialog = true
//    }
//}
//
////Ejemplo de mostrar un dialog
//if (mostrarDialog) {
//    AlertDialog(
//        onDismissRequest = {},
//        title = { Text("¡Conseguido!") },
//        text = { Text("Has tocado el icono $OBJETIVO veces. ¡TOP!") },
//        confirmButton = {
//            TextButton(onClick = {
//                mostrarDialog = false
//                contador = 0
//                offsetX = 0f
//                offsetY = 0f
//                navController.navigate(AppScreens.StartScreen.route) {
//                    popUpTo(AppScreens.StartScreen.route) { inclusive = true }
//                }
//            }) {
//                Text("Aceptar")
//            }
//        }
//    )
//}