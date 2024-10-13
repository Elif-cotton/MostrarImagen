package com.example.imagen7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var isImageVisible by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf("Mostrar imagen") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText()
        NameText()
        ShowHideImageButton(
            onButtonClick = {
                isImageVisible = !isImageVisible
                buttonText = if (isImageVisible) "Ocultar imagen" else "Mostrar imagen"
            },
            buttonText = buttonText
        )
        if (isImageVisible) {
            DisplayImage()
        }
    }
}

@Composable
fun WelcomeText() {
    Text(
        text = "¡Bienvenidos!",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun NameText() {
    Text(
        text = "Judith Vergara",
        fontSize = 30.sp,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun ShowHideImageButton(
    onButtonClick: () -> Unit,
    buttonText: String
) {
    Button(
        onClick = onButtonClick,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(text = buttonText,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold)
    }
}

@Composable
fun DisplayImage() {
    Image(
        painter = painterResource(id = R.drawable.imagen1),
        contentDescription = "Imagen de china",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}