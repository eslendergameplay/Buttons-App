package com.example.jetpack2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack2.ui.theme.Jetpack2Theme

class MainActivity : ComponentActivity() {
    val listaColores:List<Color> = listOf(Color.Red,Color.Yellow,Color.Black,Color.Cyan,Color.DarkGray,Color.Magenta,Color.Green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
        }
    }

@Preview(showBackground = true)
@Composable
fun Content(){
    var likes by remember{ mutableIntStateOf(0) }
    Column(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        .padding(horizontal = 5.dp)) {
        Texto(texto = "Juan")
        SpacerV()
        Texto(texto = "Diego")
        SpacerV()
        Texto(texto = "Serrano")
        SpacerV()
        LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            items(listaColores){
                item -> Circulo(color = item)
                SpacerH(espacio = 8)
            }
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement =
        Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                likes++
            }, colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)) {
                Text(text = "Me Gusta.")
            }
            Resultado(likes)
        }
    }
}

@Composable
fun Texto(texto:String){
    Text(text = texto, color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center,modifier = Modifier
        .background(Color.Black)
        .padding(horizontal = 30.dp)
        .fillMaxWidth()
        .clickable {
            println("Hola $texto")
        })
}

@Composable
fun Circulo(color:Color){
    Box(modifier = Modifier
        .size(70.dp)
        .background(color, CircleShape))
}

@Composable
fun SpacerV(){
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun SpacerH(espacio:Int){
    Spacer(modifier = Modifier.width(espacio.dp))
}

@Composable
fun Resultado(likes:Int){
    Text(text = likes.toString(), fontWeight = FontWeight.Bold, fontSize = 50.sp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Content()
}
}