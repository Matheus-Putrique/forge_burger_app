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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.forge_burger.Fundo
import com.example.forge_burger.FundoCard
import com.example.forge_burger.Laranja
import com.example.forge_burger.SeletorQuantidade
import com.example.forge_burger.TextoCinza
import com.example.forge_burger.TextoClaro

// ----------------------------------------------------------------------
// TELA DO CARRINHO (My Cart)
// As cores vem do MenuScreen.kt (pacote com.example.forge_burger)
// ----------------------------------------------------------------------

@Preview(showBackground = true, heightDp = 780)
@Composable
fun CustomizationScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Fundo
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Cabecalho()

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {

                Text(
                    text = "My Cart",
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = TextoClaro,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                ItemDoCarrinho(
                    foto = "🍔",
                    nome = "Classic Smash",
                    detalhes = "Medium, Extra Bacon, Extra Cheese",
                    preco = "$19.40"
                )

                Spacer(modifier = Modifier.height(12.dp))

                ItemDoCarrinho(
                    foto = "🍟",
                    nome = "Craft French Fries",
                    detalhes = "Large, Rosemary Salt",
                    preco = "$4.90"
                )

                Spacer(modifier = Modifier.height(12.dp))

                ItemDoCarrinho(
                    foto = "🍺",
                    nome = "Craft IPA Beer",
                    detalhes = "Chilled Draft Can",
                    preco = "$14.00"
                )

                Spacer(modifier = Modifier.height(20.dp))

                ResumoDoPedido(
                    subtotal = "$38.30",
                    entrega = "$4.99",
                    total = "$43.29"
                )

            }

            BotaoCheckout()

        }

    }

}

// ----------------------------------------------------------------------
// CABECALHO: voltar + nome do app + sino + foto do perfil
// ----------------------------------------------------------------------

@Preview
@Composable
fun Cabecalho(Voltar: () -> Unit = {}) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Fundo
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Surface(
                onClick = Voltar,
                modifier = Modifier.size(36.dp),
                shape = RoundedCornerShape(50),
                color = FundoCard
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "←",
                        color = TextoClaro,
                        fontSize = 16.sp
                    )
                }

            }

            Text(
                text = "BURGERCRAFT",
                color = Laranja,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "🔔",
                    modifier = Modifier.padding(end = 10.dp)
                )

                Surface(
                    modifier = Modifier.size(34.dp),
                    shape = RoundedCornerShape(50),
                    color = Color(90, 70, 55)
                ) {
                    // aqui depois entra a foto do usuario
                }

            }

        }

    }

}

// ----------------------------------------------------------------------
// UM ITEM DO CARRINHO
// ----------------------------------------------------------------------

@Preview
@Composable
fun ItemDoCarrinho(
    foto: String = "🍔",
    nome: String = "Classic Smash",
    detalhes: String = "Medium, Extra Bacon, Extra Cheese",
    preco: String = "$19.40"
) {

    var quantidade by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        color = FundoCard
    ) {

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            MiniFoto(foto)

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = nome,
                    color = TextoClaro,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = detalhes,
                    color = TextoCinza,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = preco,
                    color = Laranja,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            SeletorQuantidade(
                quantidade = quantidade,
                Menos = { if (quantidade > 1) quantidade-- },
                Mais = { quantidade++ }
            )

        }

    }

}

@Composable
fun MiniFoto(foto: String) {

    // lugar da foto (trocar por Image quando tiver as imagens)
    Surface(
        modifier = Modifier.size(60.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color(70, 50, 35)
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = foto,
                fontSize = 28.sp
            )
        }

    }

}

// ----------------------------------------------------------------------
// RESUMO DO PEDIDO
// ----------------------------------------------------------------------

@Preview
@Composable
fun ResumoDoPedido(
    subtotal: String = "$38.30",
    entrega: String = "$4.99",
    total: String = "$43.29"
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        HorizontalDivider(color = Color(60, 60, 60))

        Spacer(modifier = Modifier.height(12.dp))

        LinhaDoResumo("Subtotal", subtotal)

        Spacer(modifier = Modifier.height(6.dp))

        LinhaDoResumo("Delivery Fee", entrega)

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Total",
                color = TextoClaro,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = total,
                color = Laranja,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }

}

@Composable
fun LinhaDoResumo(texto: String, valor: String) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = texto,
            color = TextoCinza,
            fontSize = 15.sp
        )

        Text(
            text = valor,
            color = TextoClaro,
            fontSize = 15.sp
        )

    }

}

// ----------------------------------------------------------------------
// BOTAO DE FECHAR O PEDIDO
// ----------------------------------------------------------------------

@Preview
@Composable
fun BotaoCheckout(Finalizar: () -> Unit = {}) {

    Surface(
        onClick = Finalizar,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(54.dp),
        shape = RoundedCornerShape(50),
        color = Laranja
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Go to Checkout",
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }

}
