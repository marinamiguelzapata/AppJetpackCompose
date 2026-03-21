package es.riberadeltajo.appjetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.riberadeltajo.appjetpackcompose.components.BotonGenerico
import es.riberadeltajo.appjetpackcompose.navigation.AppScreens
import es.riberadeltajo.appjetpackcompose.ui.theme.Morado_dos
import es.riberadeltajo.appjetpackcompose.ui.theme.Morado_uno

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inicio") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Morado_uno,
                    titleContentColor = Color.White
                )
            )
        }
    ) {
        InicioBodyContent(navController)
    }
}

//función para establecer el contenido de la pantalla
@Composable
fun InicioBodyContent(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Bienvenido",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(24.dp))

        //uso del componente genérico
        BotonGenerico(
            texto = "Login",
            modifier = Modifier.fillMaxWidth(),
            color = Morado_uno,
            onClick = { navController.navigate(AppScreens.LoginScreen.route) }
        )

        Spacer(Modifier.height(12.dp))

        //uso del componente genérico
        BotonGenerico(
            texto = "Registrarse",
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            onClick = { navController.navigate(AppScreens.RegistroScreen.route) },
            outlined = true
        )

        Spacer(Modifier.height(12.dp))

        //uso del componente genérico
        BotonGenerico(
            texto = "Minijuego",
            modifier = Modifier.fillMaxWidth(),
            color = Morado_dos,
            onClick = { navController.navigate(AppScreens.MiniJuegoScreen.route) }
        )

    }
}
