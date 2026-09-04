package com.exemplo.meuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
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
fun CartScreen() {
    val corFundo = Color(18, 18, 18)
    val corCard = Color(28, 28, 28)
    val corLaranja = Color(255, 160, 0)
    val corTextoCinza = Color(160, 160, 160)

    var qtdLanche by remember { mutableIntStateOf(1) }
    var qtdBatata by remember { mutableIntStateOf(1) }
    var qtdCerveja by remember { mutableIntStateOf(1) }

    val precoLanche: Float = 19.40f
    val precoBatata: Float = 4.90f
    val precoCerveja: Float = 14.00f
    val taxaEntrega: Float = 4.99f

    val subtotal: Float = (qtdLanche * precoLanche) + (qtdBatata * precoBatata) + (qtdCerveja * precoCerveja)
    val totalGeral: Float = subtotal + taxaEntrega

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
            Surface(
                shape = RoundedCornerShape(50),
                color = corCard,
                modifier = Modifier.size(36.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "←", color = Color.White, fontSize = 16.sp)
                }
            }

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
            Text(
                text = "Meu Carrinho",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            CardItemDoPedido(
                foto = "🍔",
                nome = "Smash Clássico",
                descricao = "Médio, Bacon Extra, Cheddar Extra",
                preco = precoLanche,
                quantidade = qtdLanche,
                aoDiminuir = { if (qtdLanche > 1) qtdLanche-- },
                aoAumentar = { qtdLanche++ }
            )

            Spacer(modifier = Modifier.height(12.dp))

            CardItemDoPedido(
                foto = "🍟",
                nome = "Batata Frita Rústica",
                descricao = "Grande, Sal de Alecrim",
                preco = precoBatata,
                quantidade = qtdBatata,
                aoDiminuir = { if (qtdBatata > 1) qtdBatata-- },
                aoAumentar = { qtdBatata++ }
            )

            Spacer(modifier = Modifier.height(12.dp))

            CardItemDoPedido(
                foto = "🍺",
                nome = "Cerveja Artesanal IPA",
                descricao = "Lata Gelada 350ml",
                preco = precoCerveja,
                quantidade = qtdCerveja,
                aoDiminuir = { if (qtdCerveja > 1) qtdCerveja-- },
                aoAumentar = { qtdCerveja++ }
            )

            Spacer(modifier = Modifier.height(24.dp))

            HorizontalDivider(color = Color(40, 40, 40))

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Subtotal", color = corTextoCinza, fontSize = 14.sp)
                Text(text = "R$ " + "%.2f".format(subtotal), color = Color.White, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Taxa de Entrega", color = corTextoCinza, fontSize = 14.sp)
                Text(text = "R$ " + "%.2f".format(taxaEntrega), color = Color.White, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "R$ " + "%.2f".format(totalGeral),
                    color = corLaranja,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Surface(
            shape = RoundedCornerShape(25.dp),
            color = corLaranja,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "Finalizar Pedido",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun CardItemDoPedido(
    foto: String,
    nome: String,
    descricao: String,
    preco: Float,
    quantidade: Int,
    aoDiminuir: () -> Unit,
    aoAumentar: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = Color(28, 28, 28),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(45, 45, 45),
                modifier = Modifier.size(54.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = foto, fontSize = 28.sp)
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = nome, color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Text(text = descricao, color = Color(160, 160, 160), fontSize = 12.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "R$ " + "%.2f".format(preco),
                    color = Color(255, 160, 0),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(42, 42, 42)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Button(
                        onClick = aoDiminuir,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(26.dp)
                    ) {
                        Text("-", color = Color.White)
                    }

                    Text(
                        text = "$quantidade",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 6.dp),
                        fontSize = 13.sp
                    )

                    Button(
                        onClick = aoAumentar,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(26.dp)
                    ) {
                        Text("+", color = Color.White)
                    }
                }
            }
        }
    }
}