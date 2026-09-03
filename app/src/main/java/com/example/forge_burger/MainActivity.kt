package com.example.forge_burger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.forge_burger.ui.theme.Forge_BurgerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Forge_BurgerTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Fundo
                ) {

                    Surface(modifier = Modifier.padding(it)) {

                        // troque aqui pra ver outra tela:
                        // MenuScreen() / CartScreen() / CustomizationScreen()
                        MenuScreen()

                    }

                }

            }
        }
    }
}
