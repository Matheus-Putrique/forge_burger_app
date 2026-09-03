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

// ----------------------------------------------------------------------
// TELA DE DETALHE DO LANCHE (foto + descricao + botao de adicionar)
// As cores (Fundo, FundoCard, Laranja...) estao no MenuScreen.kt
// ----------------------------------------------------------------------

@Preview(showBackground = true, heightDp = 780)
@Composable
fun CartScreen(
    nome: String = "The Classic Smash",
    preco: String = "$14.90"
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Fundo
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            FotoDoLanche()

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                NomeEPreco(
                    nome = nome,
                    preco = preco
                )

                Spacer(modifier = Modifier.height(12.dp))

                Descricao(
                    "Two signature smashed beef patties, double melted " +
                        "cheddar cheese, house craft secret sauce, home-pickled " +
                        "cucumbers on a perfectly toasted brioche bun."
                )

                Spacer(modifier = Modifier.height(20.dp))

                Ingredientes()

                Spacer(modifier = Modifier.height(20.dp))

                NutritionFacts()

            }

            BarraDeCompra(preco = preco)

        }

    }

}

// ----------------------------------------------------------------------
// FOTO DO LANCHE COM OS BOTOES DE VOLTAR E FAVORITAR POR CIMA
// ----------------------------------------------------------------------

@Preview
@Composable
fun FotoDoLanche(Voltar: () -> Unit = {}) {

    var favorito by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {

        // lugar da foto (trocar por Image quando tiver as imagens)
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(70, 50, 35)
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "🍔",
                    fontSize = 90.sp
                )
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            BotaoRedondo(icone = "←", cor = TextoClaro, onClick = Voltar)

            BotaoRedondo(
                icone = if (favorito) "♥" else "♡",
                cor = Laranja,
                onClick = { favorito = !favorito }
            )

        }

    }

}

@Composable
fun BotaoRedondo(icone: String, cor: Color, onClick: () -> Unit = {}) {

    Surface(
        onClick = onClick,
        modifier = Modifier.size(40.dp),
        shape = RoundedCornerShape(50),
        color = Color(0, 0, 0, 160)
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icone,
                color = cor,
                fontSize = 18.sp
            )
        }

    }

}

// ----------------------------------------------------------------------
// NOME + PRECO
// ----------------------------------------------------------------------

@Composable
fun NomeEPreco(nome: String, preco: String) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = nome,
            color = TextoClaro,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = preco,
            color = Laranja,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

    }

}

@Composable
fun Descricao(texto: String) {

    Text(
        text = texto,
        color = TextoCinza,
        fontSize = 15.sp
    )

}

// ----------------------------------------------------------------------
// INGREDIENTES (abre e fecha ao clicar)
// ----------------------------------------------------------------------

@Preview
@Composable
fun Ingredientes() {

    var aberto by remember { mutableStateOf(false) }

    val lista = listOf(
        "2x smashed beef patty (90g)",
        "2x cheddar cheese",
        "House craft secret sauce",
        "Home-pickled cucumbers",
        "Brioche bun"
    )

    Surface(
        onClick = { aberto = !aberto },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = FundoCard
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "📋")

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Ingredients",
                        color = TextoClaro,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

                Text(
                    text = if (aberto) "▲" else "▼",
                    color = TextoCinza
                )

            }

            if (aberto) {

                Spacer(modifier = Modifier.height(12.dp))

                for (item in lista) {

                    Text(
                        text = "•  $item",
                        color = TextoCinza,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )

                }

            }

        }

    }

}

// ----------------------------------------------------------------------
// TABELA NUTRICIONAL
// ----------------------------------------------------------------------

@Preview
@Composable
fun NutritionFacts() {

    Column() {

        Text(
            text = "Nutrition Facts",
            color = TextoClaro,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {

            ChipInfo("Cal: 650")
            Spacer(modifier = Modifier.width(8.dp))
            ChipInfo("Prot: 32g")
            Spacer(modifier = Modifier.width(8.dp))
            ChipInfo("Carb: 40g")
            Spacer(modifier = Modifier.width(8.dp))
            ChipInfo("Fat: 38g")

        }

    }

}

@Composable
fun ChipInfo(texto: String) {

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = FundoCard
    ) {

        Text(
            text = texto,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            color = TextoCinza,
            fontSize = 13.sp
        )

    }

}

// ----------------------------------------------------------------------
// BARRA DE BAIXO: quantidade + adicionar ao carrinho
// ----------------------------------------------------------------------

@Preview
@Composable
fun BarraDeCompra(preco: String = "$14.90", Adicionar: () -> Unit = {}) {

    var quantidade by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Fundo
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            SeletorQuantidade(
                quantidade = quantidade,
                Menos = { if (quantidade > 1) quantidade-- },
                Mais = { quantidade++ }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Surface(
                onClick = Adicionar,
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp),
                shape = RoundedCornerShape(50),
                color = Laranja
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Add to Cart – $preco",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }

    }

}

@Composable
fun SeletorQuantidade(quantidade: Int, Menos: () -> Unit = {}, Mais: () -> Unit = {}) {

    Surface(
        shape = RoundedCornerShape(50),
        color = FundoCard
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            BotaoQuantidade("−", Menos)

            Text(
                text = "$quantidade",
                color = TextoClaro,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            BotaoQuantidade("+", Mais)

        }

    }

}

@Composable
fun BotaoQuantidade(icone: String, onClick: () -> Unit = {}) {

    Surface(
        onClick = onClick,
        color = Color.Transparent
    ) {

        Text(
            text = icone,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
            color = TextoClaro,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }

}
