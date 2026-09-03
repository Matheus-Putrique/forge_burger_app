package com.exemplo.irongrill.ui.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.compose.ui.text.font.FontWeight



@Composable
@Preview
fun CustomizationScreen() {
    androidx.compose.foundation.layout.Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Cabecalho()

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tela de Customização (Em breve)"
            )
        }
    }
}


@Composable
fun CustomizationScreenPreview() {
    CustomizationScreen()
}

@Preview
@Composable

fun Cabecalho(Voltar: () -> Unit = {}){

    Surface(
        color = Color(20, 20, 20),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = Voltar,
                shape = RoundedCornerShape(50)
            ) {
                Text("<")
            }
            Text(
                text = "Forge Burger",
                color = Color(255, 152, 0),
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83D\uDD14",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Surface(
                    modifier = Modifier.size(36.dp),
                    shape = RoundedCornerShape(50),
                    color = Color.Gray
                ) {// É para adicionar alguma imagem aqui(Matheus no cometário)}
                }
            }
        }
    }
}


@Composable
@Preview
fun PontoCarne(){
    var SeletorCarne by remember { mutableStateOf("Ao ponto") }

    val opcoes = listOf("Mal passada", "Ao ponto", "Bem passada")

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Ponto da carne",
            color = Color(255, 152, 0)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            color =  Color(30, 30, 30)
        ){}
    }
}
