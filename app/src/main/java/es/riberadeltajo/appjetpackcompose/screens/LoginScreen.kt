package es.riberadeltajo.appjetpackcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import es.riberadeltajo.appjetpackcompose.UserViewModel
import es.riberadeltajo.appjetpackcompose.components.BotonGenerico
import es.riberadeltajo.appjetpackcompose.navigation.AppScreens
import es.riberadeltajo.appjetpackcompose.ui.theme.Morado_uno

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, userViewModel: UserViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Login") },
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
    ) { padding ->
        LoginBodyContent(navController, userViewModel, Modifier.padding(padding))
    }
}

@Composable
fun LoginBodyContent(navController: NavController, userViewModel: UserViewModel, modifier: Modifier = Modifier) {
    var usuarioInput by remember { mutableStateOf("") }
    var contrasenaInput by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Iniciar sesión", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = usuarioInput,
            onValueChange = { usuarioInput = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = contrasenaInput,
            onValueChange = { contrasenaInput = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        if (errorMsg.isNotEmpty()) {
            Text(text = errorMsg, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        BotonGenerico(
            texto = "Entrar",
            modifier = Modifier.fillMaxWidth(),
            color = Morado_uno,
            onClick = {
                if (usuarioInput == userViewModel.usuarioRegistrado && 
                    contrasenaInput == userViewModel.contrasenaRegistrada &&
                    usuarioInput.isNotEmpty()) {
                    navController.navigate(AppScreens.HistoriaScreen.route)
                } else {
                    errorMsg = "Usuario o contraseña incorrectos"
                }
            }
        )
    }
}
