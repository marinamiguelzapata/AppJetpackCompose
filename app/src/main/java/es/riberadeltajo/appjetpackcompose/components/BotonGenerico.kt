package es.riberadeltajo.appjetpackcompose.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import es.riberadeltajo.appjetpackcompose.ui.theme.Morado_uno

@Composable
fun BotonGenerico(
    texto: String = "",
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF5C6BC0),
    shape: Shape = RoundedCornerShape(8.dp),
    onClick: () -> Unit,
    outlined: Boolean = false
) {
    //si el botón es blanco o transparente poner valoores por defecto
    if (outlined) {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = color
            ),
            border = ButtonDefaults.outlinedButtonBorder,
        ) {
            Text(text = texto, color = Morado_uno)
        }
    } else {

        Button(
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(containerColor = color),
            shape = shape
        ) {
            Text(text = texto, color = Color.White)
        }
    }
}
