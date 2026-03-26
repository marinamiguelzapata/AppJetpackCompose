package es.riberadeltajo.appjetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import es.riberadeltajo.appjetpackcompose.R


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
fun MinijuegoBodyContent(navController: NavController) {
    TresEnRayaConImagenes()
}

@Composable
fun TresEnRayaConImagenes() {
    var board by remember { mutableStateOf(List(9) { "" }) }
    var currentPlayer by remember { mutableStateOf("android") }
    var winner by remember { mutableStateOf<String?>(null) }
    var mostrarDialog by remember { mutableStateOf(false) }

    // Mostrar diálogo cuando haya ganador
    LaunchedEffect(winner) {
        when {
            winner != null -> {
                mostrarDialog = true
            }
            board.none { it.isEmpty() } -> {
                // Tablero lleno y sin ganador
                mostrarDialog = true
            }
        }
//        if (winner != null) {
//            mostrarDialog = true
//        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = when {
                winner != null -> "Ganador: ${winner!!.uppercase()}"
                board.none { it.isEmpty() } -> "Empate"
                else -> "Turno: ${currentPlayer.uppercase()}"
            },
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        //tablero 3x3 centrado en pantalla
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                for (row in 0 until 3) {
                    Row(modifier = Modifier.weight(1f)) {
                        for (col in 0 until 3) {
                            val index = row * 3 + col
                            CasillaImagen(
                                value = board[index],
                                enabled = board[index].isEmpty() && winner == null,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ) {
                                board = board.toMutableList().also { it[index] = currentPlayer }
                                winner = checkWinner(board)
                                if (winner == null) {
                                    currentPlayer = if (currentPlayer == "android") "iphone" else "android"
                                }
                            }
                        }
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            board = List(9) { "" }
            currentPlayer = "android"
            winner = null
            mostrarDialog = false
        }) {
            Text("Reiniciar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Turno de: ${if (currentPlayer == "android") "ANDROID" else "IOS"}",
            style = MaterialTheme.typography.headlineSmall
        )

    }

    //diálogo de victoria
    if (mostrarDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(
                    if (winner != null) "¡Tenemos ganador!"
                    else "No hay ganador"
                )
            },
            text = {
                Text(
                    if (winner != null) "${winner!!.uppercase()} gana"
                    else "Las casillas están completas"
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    board = List(9) { "" }
                    currentPlayer = "android"
                    winner = null
                    mostrarDialog = false
                }) {
                    Text("Aceptar")
                }
            }
        )
    }

}

@Composable
fun CasillaImagen(
    value: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .background(Color(0xFFE0E0E0))
            .clickable(enabled = enabled) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        when (value) {
            "android" -> Image(
                painter = painterResource(id = R.drawable.androidverde),
                contentDescription = "Android",
                modifier = Modifier.size(70.dp)
            )
            "iphone" -> Image(
                painter = painterResource(id = R.drawable.applenegro),
                contentDescription = "iPhone",
                modifier = Modifier.size(70.dp)
            )
        }
    }
}


fun checkWinner(board: List<String>): String? {
    val winPatterns = listOf(
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )

    for (pattern in winPatterns) {
        val (a, b, c) = pattern
        if (board[a].isNotEmpty() && board[a] == board[b] && board[a] == board[c]) {
            return board[a]
        }
    }
    return null
}


