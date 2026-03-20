package es.riberadeltajo.appjetpackcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen(navController: NavController) {

    val morado = Color(0xFF5C6BC0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inicio") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = morado,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text("Bienvenido")

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(containerColor = morado)
            ) {
                Text("Login")
            }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onClick = { navController.navigate("registro") }
            ) {
                Text("Registrarse")
            }

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = { navController.navigate("minijuego") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7B3F9E))
            ) {
                Text("Minijuego")
            }

        }
    }
}