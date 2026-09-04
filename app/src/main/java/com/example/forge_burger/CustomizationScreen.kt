package com.exemplo.meuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun CustomizationScreen() {
    val corFundo = Color(18, 18, 18)
    val corCard = Color(28, 28, 28)
    val corLaranja = Color(255, 160, 0)
    val corTextoCinza = Color(160, 160, 160)

    var quantidade by remember { mutableIntStateOf(1) }
    val precoBase: Float = 14.90f
    val precoTotalAtual: Float = precoBase * quantidade

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(corFundo)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(Color(40, 30, 25))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "🍔", fontSize = 110.sp)
                }

                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0, 0, 0, 120),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .size(38.dp)
                        .align(Alignment.TopStart)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "←", color = Color.White, fontSize = 18.sp)
                    }
                }

                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0, 0, 0, 120),
                    modifier = Modifier
                        .padding(end = 16.dp, top = 16.dp)
                        .size(38.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "♡", color = corLaranja, fontSize = 20.sp)
                    }
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Smash Clássico",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "R$ " + "%.2f".format(precoBase),
                        color = corLaranja,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Dois hambúrgueres artesanais smash de 90g, queijo cheddar duplo derretido, molho secreto artesanal e picles da casa no pão brioche tostado na manteiga.",
                    color = corTextoCinza,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = corCard,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Ingredientes Inclusos",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "• 2x Carnes Smash (90g cada)\n• Queijo Cheddar Artesanal\n• Picles Fatiado\n• Molho Especial BurgerCraft\n• Pão Brioche Selado",
                            color = corTextoCinza,
                            fontSize = 13.sp,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(24, 24, 24)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(25.dp),
                    color = corCard
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                    ) {
                        Button(
                            onClick = { if (quantidade > 1) quantidade-- },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier.size(32.dp)
                        ) {
                            Text("-", color = Color.White, fontSize = 16.sp)
                        }

                        Text(
                            text = "$quantidade",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )

                        Button(
                            onClick = { quantidade++ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier.size(32.dp)
                        ) {
                            Text("+", color = Color.White, fontSize = 16.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Surface(
                    shape = RoundedCornerShape(25.dp),
                    color = corLaranja,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = "Adicionar • R$ " + "%.2f".format(precoTotalAtual),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}