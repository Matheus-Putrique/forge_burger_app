package com.example.forge_burger

import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ----------------------------------------------------------------------
// CORES DO APP (deixei aqui em cima pra facilitar mudar depois)
// ----------------------------------------------------------------------

val Fundo = Color(18, 18, 18)
val FundoCard = Color(30, 30, 30)
val Laranja = Color(255, 152, 0)
val TextoClaro = Color(240, 240, 240)
val TextoCinza = Color(160, 160, 160)

// ----------------------------------------------------------------------
// TELA PRINCIPAL (junta todas as funcoes de baixo)
// ----------------------------------------------------------------------

@Preview(showBackground = true, heightDp = 780)
@Composable
fun MenuScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Fundo
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            CabecalhoMenu()

            // miolo da tela: rola pra baixo se nao couber
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {

                BarraDePesquisa()

                Categorias()

                TituloSecao("Artisanal Burgers")

                GradeDeBurgers()

                Spacer(modifier = Modifier.height(16.dp))

            }

            BarraInferior()

        }

    }

}

// ----------------------------------------------------------------------
// CABECALHO: menu + nome do app + sino + foto do perfil
// ----------------------------------------------------------------------

@Preview
@Composable
fun CabecalhoMenu(AbrirMenu: () -> Unit = {}) {

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

            Text(
                text = "☰",
                color = TextoClaro,
                fontSize = 22.sp
            )

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
// BARRA DE PESQUISA
// ----------------------------------------------------------------------

@Preview
@Composable
fun BarraDePesquisa() {

    var busca by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(14.dp),
        color = FundoCard
    ) {

        Row(
            modifier = Modifier.padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "🔍")

            TextField(
                value = busca,
                onValueChange = { busca = it },
                placeholder = {
                    Text(
                        text = "Search burgers, drinks, sides...",
                        color = TextoCinza
                    )
                },
                singleLine = true,
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = TextoClaro,
                    unfocusedTextColor = TextoClaro,
                    cursorColor = Laranja,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Text(text = "🎤")

        }

    }

}

// ----------------------------------------------------------------------
// CATEGORIAS (Burgers / Drinks / Combos / Sides)
// ----------------------------------------------------------------------

@Preview
@Composable
fun Categorias() {

    var selecionada by remember { mutableStateOf("Burgers") }

    val opcoes = listOf("Burgers", "Drinks", "Combos", "Sides")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        for (opcao in opcoes) {

            Categoria(
                texto = opcao,
                selecionada = opcao == selecionada,
                onClick = { selecionada = opcao }
            )

            Spacer(modifier = Modifier.width(10.dp))

        }

    }

}

@Composable
fun Categoria(texto: String, selecionada: Boolean, onClick: () -> Unit = {}) {

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        color = if (selecionada) Laranja else FundoCard
    ) {

        Text(
            text = texto,
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp),
            color = if (selecionada) Color.Black else TextoClaro,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

    }

}

// ----------------------------------------------------------------------
// TITULO DA SECAO
// ----------------------------------------------------------------------

@Composable
fun TituloSecao(titulo: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = titulo,
            color = TextoClaro,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "≡",
            color = TextoCinza,
            fontSize = 20.sp
        )

    }

}

// ----------------------------------------------------------------------
// GRADE COM OS BURGERS (2 por linha)
// ----------------------------------------------------------------------

@Preview
@Composable
fun GradeDeBurgers() {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        Row() {

            CardBurger(
                nome = "Triple Bacon Smash",
                nota = "4.9",
                preco = "$12.90",
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            CardBurger(
                nome = "Spicy Jalapeño Smash",
                nota = "4.7",
                preco = "$11.50",
                modifier = Modifier.weight(1f)
            )

        }

        Spacer(modifier = Modifier.height(12.dp))

        Row() {

            CardBurger(
                nome = "Truffle Mushroom",
                nota = "4.8",
                preco = "$13.50",
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            CardBurger(
                nome = "Classic Craft Smash",
                nota = "4.6",
                preco = "$9.90",
                modifier = Modifier.weight(1f)
            )

        }

    }

}

// ----------------------------------------------------------------------
// CARD DE UM BURGER
// ----------------------------------------------------------------------

@Preview
@Composable
fun CardBurger(
    nome: String = "Triple Bacon Smash",
    nota: String = "4.9",
    preco: String = "$12.90",
    modifier: Modifier = Modifier,
    Adicionar: () -> Unit = {}
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = FundoCard
    ) {

        Column() {

            // lugar da foto do lanche (trocar por Image quando tiver as imagens)
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                color = Color(70, 50, 35)
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🍔",
                        fontSize = 46.sp
                    )
                }

            }

            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Text(
                    text = nome,
                    color = TextoClaro,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "🏅")

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = nota,
                        color = TextoCinza,
                        fontSize = 13.sp
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = preco,
                        color = Laranja,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    BotaoAdicionar(Adicionar)

                }

            }

        }

    }

}

@Composable
fun BotaoAdicionar(onClick: () -> Unit = {}) {

    Surface(
        onClick = onClick,
        modifier = Modifier.size(34.dp),
        shape = RoundedCornerShape(50),
        color = Laranja
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "+",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }

}

// ----------------------------------------------------------------------
// BARRA DE BAIXO (Home / Search / Cart / Profile)
// ----------------------------------------------------------------------

@Preview
@Composable
fun BarraInferior() {

    var aba by remember { mutableStateOf("Home") }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(24, 24, 24)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            ItemDaBarra("🏠", "Home", aba == "Home") { aba = "Home" }
            ItemDaBarra("🔍", "Search", aba == "Search") { aba = "Search" }
            ItemDaBarra("🛒", "Cart", aba == "Cart") { aba = "Cart" }
            ItemDaBarra("👤", "Profile", aba == "Profile") { aba = "Profile" }

        }

    }

}

@Composable
fun ItemDaBarra(icone: String, texto: String, selecionado: Boolean, onClick: () -> Unit = {}) {

    Surface(
        onClick = onClick,
        color = Color.Transparent
    ) {

        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = icone)

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = texto,
                color = if (selecionado) Laranja else TextoCinza,
                fontSize = 12.sp,
                fontWeight = if (selecionado) FontWeight.Bold else FontWeight.Normal
            )

        }

    }

}
