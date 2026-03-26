package es.riberadeltajo.appjetpackcompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.riberadeltajo.appjetpackcompose.ui.theme.Morado_uno

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoriaScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Campeones de LoL") },
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

@Composable
fun HistoriaBodyContent(paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(champions) { champion ->
            MyComponent(champion)
        }
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
}

@Composable
fun MyTexts(message: MyMessage) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if (expanded) Int.MAX_VALUE else 2
        )
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            MyTexts(message)
        }
    }
}

data class MyMessage(val title: String, val body: String)

private val champions: List<MyMessage> = listOf(
    MyMessage(
        "Aatrox - La Espada de los Oscuros",
        "Aatrox y sus hermanos, otrora defensores celestiales de Shurima contra el Vacío, acabarían convirtiéndose en una amenaza aún mayor para Runaterra y solo conocieron la derrota ante hechizos mortales y astutos. Pero tras siglos de encarcelamiento, Aatrox fue el primero en recuperar su libertad, tras corromper y transformar a aquellos lo suficientemente necios como para intentar empuñar el arma mágica que contenía su esencia."
    ),
    MyMessage(
        "Ahri - La Mujer Zorro de Nueve Colas",
        "Ahri es una vastaya conectada de forma innata al poder mágico de Runaterra, capaz de convertir la magia en orbes de energía pura. Disfruta jugando con su presa, manipulando sus emociones antes de devorar su esencia vital. A pesar de su naturaleza depredadora, Ahri conserva un sentido de la empatía al recibir recuerdos de cada alma que consume."
    ),
    MyMessage(
        "Akali - La Asesina Furtiva",
        "Akali, que ha abandonado la Orden Kinkou y su título de Puño de la Sombra, ahora actúa en solitario y está lista para convertirse en el arma letal que su pueblo necesita. Aunque no olvida nada de lo que aprendió de su maestro Shen, ha jurado defender Jonia de sus enemigos, eliminándolos de uno en uno."
    ),
    MyMessage(
        "Jinx - La Bala Perdida",
        "Jinx, una criminal impulsiva y maníaca de Zaun, vive para sembrar el caos sin pararse a pensar en las consecuencias. Con un arsenal de armas letales a su disposición, desata las explosiones más ruidosas y cegadoras para dejar un rastro de pánico y confusión a su paso. Jinx detesta el aburrimiento y disfruta dejando su propia marca de caos allá donde va."
    ),
    MyMessage(
        "Yasuo - El Imperdonable",
        "Yasuo, un jonio de gran determinación, es un ágil espadachín capaz de manipular el viento para cortar a sus enemigos. De joven, fue el único estudiante de su generación que logró dominar la legendaria técnica del viento. Sin embargo, fue acusado injustamente de asesinar a su maestro y, ahora, se ve obligado a vagar por el mundo en busca de justicia."
    ),
    MyMessage(
        "Lux - La Dama Luminosa",
        "Luxanna Crownguard nació en Demacia, un reino donde se ve a la magia con temor y suspicacia. Capaz de manipular la luz a su voluntad, creció temiendo que la descubrieran y la exiliaran, por lo que se vio obligada a mantener sus poderes en secreto para preservar el honor de su familia."
    ),
    MyMessage(
        "Teemo - El Explorador Veloz",
        "Teemo no se deja amedrentar por los obstáculos más peligrosos y amenazadores; viaja por el mundo con un entusiasmo infinito y un espíritu alegre. Es un yordle con una moralidad inquebrantable que se enorgullece de seguir el Código de los Exploradores de Bandle, a veces con tanto ímpetu que no es consciente de las consecuencias de sus acciones."
    ),
    MyMessage(
        "Lee Sin - El Monje Ciego",
        "Maestro de las artes marciales ancestrales de Jonia, Lee Sin es un luchador con principios que canaliza la esencia del espíritu del dragón para enfrentarse a cualquier desafío. Aunque perdió la vista hace muchos años, el monje guerrero ha dedicado su vida a proteger su tierra natal contra cualquiera que ose perturbar su sagrado equilibrio."
    ),
    MyMessage(
        "Garen - El Poder de Demacia",
        "Garen, un orgulloso y noble guerrero, lucha en las filas de la Vanguardia Intrépida. Es popular entre sus compañeros y respetado por sus enemigos, y no es para menos, pues es descendiente de la prestigiosa familia Crownguard, encargada de defender Demacia y sus ideales."
    ),
    MyMessage(
        "Katarina - La Cuchilla Siniestra",
        "Katarina, una de las asesinas más letales de Noxus, posee un instinto asesino sin igual. Hija del legendario general Du Couteau, Katarina es conocida por sus rápidos asesinatos contra enemigos desprevenidos. Su ambición la ha llevado a buscar objetivos cada vez más peligrosos, incluso a riesgo de poner en peligro su propia reputación."
    ),
    MyMessage(
        "Ezreal - El Explorador Pródigo",
        "Ezreal, un aventurero audaz con un talento innato para las artes mágicas, explora catacumbas perdidas, se adentra en antiguas maldiciones y supera con facilidad las situaciones más difíciles. Su valor y audacia no conocen límites, y prefiere confiar en su ingenio y en su guantelete místico de Shurima para salir de cualquier apuro."
    ),
    MyMessage(
        "Ashe - La Arquera de Hielo",
        "Ashe, la madre de guerra de la tribu de los Avarosa, lidera la horda más numerosa del norte. Impasible, inteligente e idealista, pero poco cómoda en su papel de líder, Ashe canaliza las energías mágicas de su linaje para empuñar un arco de Hielo Verdadero."
    ),
    MyMessage(
        "Thresh - El Carcelero de las Almas",
        "Sádico y astuto, Thresh es un espíritu ambicioso e incansable de las Islas de la Sombra. Una vez fue el guardián de innumerables secretos arcanos, pero fue deshecho por un poder mayor que la vida o la muerte, y ahora se sustenta atormentando y quebrando a los demás con una lentitud e ingenio atroces."
    ),
    MyMessage(
        "Zed - El Maestro de las Sombras",
        "Zed, el líder de la Orden de la Sombra, es el primero en doscientos años en desbloquear las artes antiguas y prohibidas. Destruye a todo aquel que considera una amenaza para su nación, Jonia, o para su nueva orden. Con sus sombras a su lado, Zed es capaz de acabar con sus enemigos antes de que estos siquiera noten su presencia."
    ),
    MyMessage(
        "Darius - La Mano de Noxus",
        "No existe mayor símbolo del poder de Noxus que Darius, el líder más temido y curtido en batalla de toda la nación. Desde sus humildes orígenes hasta convertirse en la Mano de Noxus, Darius se abre paso a través de los enemigos del imperio, muchos de ellos incluso noxianos."
    ),
    MyMessage(
        "Vayne - La Cazadora Nocturna",
        "Shauna Vayne es una mortífera cazadora de monstruos demaciana que ha dedicado su vida a encontrar y destruir al demonio que asesinó a su familia. Armada con su ballesta de muñeca y con un corazón ansioso de venganza, solo es verdaderamente feliz cuando asesina a aquellos que practican las artes oscuras."
    ),
    MyMessage(
        "Malphite - El Fragmento del Monolito",
        "Malphite, una criatura masiva de piedra viva, lucha por imponer el orden en un mundo caótico. Creado como un fragmento de servicio de un obelisco de otro mundo conocido como el Monolito, Malphite usó su tremenda fuerza elemental para mantener la armonía, una tarea que ha resultado ser casi imposible."
    ),
    MyMessage(
        "Seraphine - La Cantante de Ojos Radiantes",
        "Nacida en Piltover de padres zaunitas, Seraphine puede escuchar las almas de los demás. El mundo le canta, y ella le devuelve la canción. Aunque estos sonidos la abrumaban de joven, ahora los utiliza como inspiración, convirtiendo el caos en una sinfonía."
    ),
    MyMessage(
        "Vi - La Agente de Piltover",
        "Antigua criminal de los suburbios de Zaun, Vi es una mujer impulsiva, imponente y temible con un respeto muy laxo por las figuras de autoridad. Habiendo crecido casi sola, Vi desarrolló instintos de supervivencia finamente pulidos, así como un sentido del humor ácido."
    ),
    MyMessage(
        "Caitlyn - La Sheriff de Piltover",
        "Famosa por ser su mejor pacificadora, Caitlyn es también la mejor baza de Piltover para librar a la ciudad de sus elusivos elementos criminales. A menudo trabaja con Vi, actuando como un contrapunto frío y sereno a la naturaleza impetuosa de su compañera."
    )
)
