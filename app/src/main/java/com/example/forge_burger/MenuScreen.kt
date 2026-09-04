package com.exemplo.meuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, heightDp = 800)
@Composable
fun MenuScreen() {
    val corFundo = Color(18, 18, 18)
    val corCard = Color(28, 28, 28)
    val corLaranja = Color(255, 160, 0)
    val corTextoCinza = Color(160, 160, 160)

    var categoriaSelecionada by remember { mutableStateOf("Hambúrgueres") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(corFundo)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "☰", color = Color.White, fontSize = 22.sp)
            Text(
                text = "BURGERCRAFT",
                color = corLaranja,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "🔔", fontSize = 18.sp, modifier = Modifier.padding(end = 10.dp))
                Surface(
                    modifier = Modifier.size(34.dp),
                    shape = RoundedCornerShape(50),
                    color = Color(80, 60, 50)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "👤", fontSize = 16.sp)
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                color = corCard
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "🔍", fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Buscar lanches, bebidas, porções...",
                        color = corTextoCinza,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(text = "🎙️", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                val categorias = listOf("Hambúrgueres", "Bebidas", "Combos", "Acompanhamentos")
                categorias.forEach { nome ->
                    val ativo = (nome == categoriaSelecionada)
                    Surface(
                        onClick = { categoriaSelecionada = nome },
                        shape = RoundedCornerShape(20.dp),
                        color = if (ativo) corLaranja else corCard,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(
                            text = nome,
                            color = if (ativo) Color.Black else corTextoCinza,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Lanches Artesanais",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "🎚️", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Linha 1
            Row(modifier = Modifier.fillMaxWidth()) {
                CardMenuBurger(
                    foto = "🍔",
                    nome = "Smash Triplo Bacon",
                    nota = "4.9",
                    preco = 12.90f,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                CardMenuBurger(
                    foto = "🍔",
                    nome = "Smash Jalapeño",
                    nota = "4.7",
                    preco = 11.50f,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                CardMenuBurger(
                    foto = "🍔",
                    nome = "Cogumelo Trufado",
                    nota = "4.8",
                    preco = 13.50f,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                CardMenuBurger(
                    foto = "🍔",
                    nome = "Smash Clássico",
                    nota = "4.6",
                    preco = 9.90f,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = corCard
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ItemBarraNavegacao(icone = "🏠", label = "Início", selecionado = true)
                ItemBarraNavegacao(icone = "🔍", label = "Buscar", selecionado = false)
                ItemBarraNavegacao(icone = "🛍️", label = "Carrinho", selecionado = false)
                ItemBarraNavegacao(icone = "👤", label = "Perfil", selecionado = false)
            }
        }
    }
}

@Composable
fun CardMenuBurger(
    foto: String,
    nome: String,
    nota: String,
    preco: Float,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(28, 28, 28),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(45, 45, 45),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = foto, fontSize = 48.sp)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = nome,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "⭐", fontSize = 12.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = nota, color = Color(160, 160, 160), fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "R$ " + "%.2f".format(preco),
                    color = Color(255, 160, 0),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(255, 160, 0),
                    modifier = Modifier.size(28.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "+", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun ItemBarraNavegacao(icone: String, label: String, selecionado: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = icone, fontSize = 18.sp)
        Text(
            text = label,
            fontSize = 11.sp,
            color = if (selecionado) Color(255, 160, 0) else Color(160, 160, 160)
        )
    }
}