package es.riberadeltajo.appjetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.riberadeltajo.appjetpackcompose.ui.theme.Morado_uno




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoriaScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Historia de España") },
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
    ) { paddingValues ->
        HistoriaBodyContent(paddingValues)
    }

}



//función para establecer el contenido de la pantalla
@Composable
fun HistoriaBodyContent(paddingValues: PaddingValues){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(message) { msg ->
            MyComponent(msg)
        }
    }
}





@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text, color = color, style = style, maxLines = lines) // elemento text que recibe como parémetro "text"
}


// ejemplo de componente formado por otros componentes
@Composable
fun MyTexts(message: MyMessage){ //para que el elemento sea genérico, le pasamos el texto por parámetros

    //variable local a nivel de función
    var expanded by remember { mutableStateOf(false) }

    //envolver en columna para que no aparezca un texto encima del otro y se superpongan
    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable { //padding al principio (a la izquierda). Modificador para clic
            expanded = !expanded
        }) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp)) //espaciado entre elementos
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if(expanded) Int.MAX_VALUE else 1
        )
    }
}


@Composable
fun MyComponent(message: MyMessage){
    Card(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation( //sombra
            defaultElevation = 5.dp
        )
    ) { //mofificadores para aplicar diferentes efectos a todo el bloque
        Column(modifier = Modifier.padding(16.dp)) {
            MyTexts(message)
        }
    }
}

//función para lista de elementos (en este caso una lista de mensajes)
@Composable
fun MyMessages(message: List<MyMessage>){
    LazyColumn() {
        //importar import androidx.compose.foundation.lazy.items
        //item se va a ejecutar una vez por cada elemento de la lista
        items(message) {
                message ->
            MyComponent(message)
        }
    }
}

//objeto para englobar parámetros
data class MyMessage(val title:String, val body: String)

//constante que guarda listado de mensajes con historia de españa
private val message: List<MyMessage> =
    listOf(
        MyMessage(
            "La Prehistoria en la Península Ibérica",
            "La presencia humana en la Península Ibérica se remonta a más de un millón de años. "
                    + "Destacan yacimientos como Atapuerca, donde se han encontrado restos del Homo Antecessor. "
                    + "Durante el Paleolítico, los grupos humanos eran nómadas y vivían de la caza y la recolección. "
                    + "En el Neolítico surgieron los primeros asentamientos estables, la agricultura y la ganadería, "
                    + "lo que transformó profundamente la forma de vida de las comunidades."
        ),
        MyMessage(
            "Los Íberos, Celtas y Tartessos",
            "Antes de la llegada de los romanos, la península estaba habitada por diversos pueblos. "
                    + "Los íberos ocupaban el este y sur, desarrollando una cultura avanzada con escritura propia. "
                    + "Los celtas vivían en el norte y centro, organizados en tribus. "
                    + "En el suroeste floreció Tartessos, una civilización rica en metales y comercio. "
                    + "La mezcla de estas culturas dio lugar a una gran diversidad cultural."
        ),
        MyMessage(
            "La Hispania Romana",
            "Roma conquistó la península entre los siglos III y I a.C. Tras décadas de guerras, Hispania se integró "
                    + "plenamente en el Imperio Romano. Se construyeron calzadas, acueductos, teatros y ciudades como "
                    + "Emerita Augusta o Tarraco. El latín se extendió y dio origen a las lenguas romances. "
                    + "La romanización marcó profundamente la identidad cultural, jurídica y social de España."
        ),
        MyMessage(
            "El Reino Visigodo",
            "Tras la caída del Imperio Romano, los visigodos establecieron su capital en Toledo. "
                    + "Unificaron gran parte del territorio y crearon un reino estable durante casi tres siglos. "
                    + "El III Concilio de Toledo fue clave para la unificación religiosa. "
                    + "Sin embargo, las luchas internas debilitaron el reino, facilitando la posterior invasión musulmana."
        ),
        MyMessage(
            "Al-Ándalus y la Convivencia",
            "En el año 711, tropas musulmanas cruzaron el Estrecho y derrotaron a los visigodos. "
                    + "Durante siglos, Al-Ándalus fue un centro de ciencia, arte y cultura. "
                    + "Ciudades como Córdoba, Sevilla y Granada brillaron por su arquitectura, bibliotecas y avances "
                    + "en matemáticas, medicina y astronomía. La convivencia entre musulmanes, cristianos y judíos "
                    + "marcó una etapa única en la historia peninsular."
        ),
        MyMessage(
            "La Reconquista",
            "Los reinos cristianos del norte iniciaron un proceso de expansión hacia el sur que duró casi ocho siglos. "
                    + "Castilla, Aragón, Navarra y Portugal fueron ganando territorio progresivamente. "
                    + "Momentos clave fueron la toma de Toledo en 1085, las Navas de Tolosa en 1212 y la conquista de Granada "
                    + "en 1492, que puso fin al Reino Nazarí y completó la unificación territorial bajo los Reyes Católicos."
        ),
        MyMessage(
            "Los Reyes Católicos",
            "Isabel I de Castilla y Fernando II de Aragón consolidaron la monarquía autoritaria, unificaron instituciones "
                    + "y apoyaron la expansión marítima. En 1492 financiaron el viaje de Cristóbal Colón, iniciando la "
                    + "presencia española en América. Su reinado marcó el inicio de la Edad Moderna en España."
        ),
        MyMessage(
            "El Imperio Español",
            "Durante los siglos XVI y XVII, España se convirtió en una potencia mundial. "
                    + "Con territorios en Europa, América, África y Asia, el imperio era conocido como 'el imperio donde nunca se pone el sol'. "
                    + "Figuras como Carlos I y Felipe II protagonizaron esta expansión. "
                    + "La riqueza americana impulsó el arte y la cultura, pero también generó conflictos y crisis económicas."
        ),
        MyMessage(
            "La Guerra de Independencia",
            "En 1808, la invasión napoleónica provocó una guerra brutal en toda la península. "
                    + "El pueblo español se levantó contra el ejército francés, dando lugar a una guerra de guerrillas. "
                    + "En 1812 se promulgó la Constitución de Cádiz, una de las primeras constituciones liberales de Europa. "
                    + "La guerra terminó en 1814 con la expulsión de los franceses."
        ),
        MyMessage(
            "La España Contemporánea",
            "El siglo XX estuvo marcado por grandes transformaciones: la dictadura de Primo de Rivera, la Segunda República, "
                    + "la Guerra Civil (1936–1939) y la dictadura de Franco. Tras su muerte en 1975, España inició la Transición "
                    + "hacia la democracia, consolidándose como un país moderno, europeo y plural. "
                    + "Hoy en día, España es una democracia parlamentaria con una rica diversidad cultural."
        ),
        MyMessage(
            "Imagen: La Alhambra de Granada",
            "La Alhambra es uno de los monumentos más emblemáticos de España y un símbolo del legado andalusí. "
                    + "Construida entre los siglos XIII y XV, destaca por su arquitectura, sus jardines y su decoración "
                    + "geométrica. Puedes mostrar aquí una imagen en tu UI para enriquecer la pantalla."
        ),
        MyMessage(
                "La Edad Media en los Reinos Cristianos",
        "Tras los primeros avances de la Reconquista, los reinos cristianos del norte comenzaron a consolidarse. "
                + "Asturias, León, Castilla, Navarra, Aragón y Portugal desarrollaron estructuras políticas propias, "
                + "fortalecieron sus ciudades y promovieron el comercio. Durante esta etapa surgieron las primeras universidades, "
                + "como la de Salamanca, y se construyeron catedrales góticas que aún hoy son símbolos del patrimonio español."
        ),
        MyMessage(
            "El Siglo de Oro",
            "Entre los siglos XVI y XVII floreció una de las etapas culturales más brillantes de la historia de España. "
                    + "Autores como Cervantes, Lope de Vega, Quevedo y Calderón revolucionaron la literatura, mientras que "
                    + "pintores como Velázquez y El Greco elevaron la pintura a niveles extraordinarios. "
                    + "Este periodo destacó por su creatividad, su riqueza artística y su influencia en toda Europa."
        ),
        MyMessage(
            "La Industrialización y los Cambios Sociales",
            "Durante el siglo XIX, España vivió un proceso de modernización marcado por la llegada del ferrocarril, "
                    + "el crecimiento de las ciudades y el surgimiento de nuevas clases sociales. "
                    + "Aunque la industrialización fue más lenta que en otros países europeos, transformó la economía y la vida cotidiana. "
                    + "También fue un siglo de inestabilidad política, con guerras civiles, cambios de gobierno y reformas profundas."
        ),
        MyMessage(
            "La Democracia y la España Actual",
            "Tras la Transición iniciada en 1975, España adoptó una Constitución democrática en 1978 que estableció un Estado social "
                    + "y de derecho. Desde entonces, el país ha experimentado un notable desarrollo económico, social y cultural. "
                    + "La integración en la Unión Europea, la descentralización territorial y el avance de los derechos civiles "
                    + "han definido la España contemporánea, diversa y abierta al mundo."
        )
)