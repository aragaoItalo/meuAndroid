package com.example.meuandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meuandroid.ui.theme.MeuAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Var p campo de texto
            var txtFieldValue = rememberSaveable {
                mutableStateOf("")
            }
            // Var p o contador
            var counterValue = rememberSaveable {
                mutableStateOf(0)
            }
            
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "Testando")
                Text(text = "Contador: ${counterValue.value}") // Exibe o valor do contador
                TextField(value = txtFieldValue.value, onValueChange = {
                    txtFieldValue.value = it
                    Log.i("###", it)
                })
                
                // Botão 
                Button(onClick = {
                    counterValue.value += 1 // Incremento do contador
                }) {
                    Text(text = "Incrementar Contador")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeuAndroidTheme {
        Greeting("Android do Italo")
    }
}