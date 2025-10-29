package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // Call your main UI function
                BusinessCardScreen()
            }
        }
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically, // Aligns icon and text in the center of the row
        modifier = Modifier.padding(horizontal = 48.dp) // Added padding for better spacing
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84), // Match your theme color
            modifier = Modifier.size(24.dp).padding(end = 16.dp)
        )
        Text(text = text)
    }
}

@Composable
fun MainInfoSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // Centers the items within this column
        modifier = Modifier.padding(top = 100.dp) // Add top padding to keep it off the very edge
    ) {
        // 1. The Android Logo
        Image(
            painter = painterResource(id = R.drawable.android_logo), // Replace 'android_logo' with your image name
            contentDescription = "Android Logo", // Set to null if it's purely decorative
            modifier = Modifier.size(150.dp) // Example: Set size
        )

        // 2. Your Name
        Text(
            text = "Mohammed Nazir Yusif",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )

        // 3. Your Title
        Text(
            text = "Android Developer",
            color = Color(0xFF3ddc84), // Example: Android Green
            fontSize = 18.sp
        )
    }
}

@Composable
fun ContactInfoSection() {
    Column(
        modifier = Modifier.padding(bottom = 32.dp) // Add padding to lift it from the bottom edge
    ) {
        // 1. Phone Number Row
        ContactItem(
            icon = Icons.Rounded.Phone,
            text = "+1 (555) 123-5882"
        )
        Spacer(Modifier.height(8.dp)) // Explicit vertical space

        // 2. Social Media Handle Row
        ContactItem(
            icon = Icons.Rounded.Share,
            text = "@MySocialHandle"
        )
        Spacer(Modifier.height(8.dp))

        // 3. Email Row
        ContactItem(
            icon = Icons.Rounded.Email,
            text = "my.email@example.com"
        )
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier.fillMaxSize(), // Makes the column take the whole screen
        horizontalAlignment = Alignment.CenterHorizontally, // Centers contents horizontally
        verticalArrangement = Arrangement.SpaceBetween // Pushes content to the top and bottom
    ) {
        MainInfoSection()


        ContactInfoSection()
    }
}
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        // This is the function Android Studio will show in the design pane.
        BusinessCardScreen()
    }
}
