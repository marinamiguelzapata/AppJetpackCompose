package es.riberadeltajo.appjetpackcompose


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var usuarioRegistrado by mutableStateOf("")
    var contrasenaRegistrada by mutableStateOf("")
}
