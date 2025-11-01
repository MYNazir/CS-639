package com.example.circleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.circleapp.ui.theme.CircleAppTheme
import kotlin.math.PI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CircleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CircleAreaCalculator()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircleAreaCalculator() {
    var radiusInput by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    // Container with padding and background colors to use several colors
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD)) // light blue background
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Circle Area Calculator",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF0D47A1) // dark blue
        )

        OutlinedTextField(
            value = radiusInput,
            onValueChange = { radiusInput = it },
            label = { Text("Enter radius") },
            placeholder = { Text("Radius as a positive number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val radius = radiusInput.toDoubleOrNull()
                resultText = if (radius == null || radius <= 0.0) {
                    "Please enter a valid positive number for the radius."
                } else {
                    val area = PI * radius * radius
                    "Area of Circle: $area"
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)) // blue button
        ) {
            Text(text = "Calculate", color = Color.White)
        }

        Text(
            text = resultText,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF004D40) // teal
        )

        Image(
            painter = painterResource(id = R.drawable.circle_icon_16077),
            contentDescription = "Circle Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircleAreaCalculatorPreview() {
    CircleAppTheme {
        CircleAreaCalculator()
    }
}
