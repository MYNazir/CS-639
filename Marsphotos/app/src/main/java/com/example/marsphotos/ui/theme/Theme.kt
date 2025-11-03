/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.marsphotos.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// NOTE: Ensure your Color.kt file contains the MarsPrimaryXX, MarsSecondaryXX,
// and MarsTertiaryXX variables and their corresponding Color imports.

private val DarkColorScheme = darkColorScheme(
    primary = MarsPrimary80,    // Replaces Purple80
    secondary = MarsSecondary80, // Replaces PurpleGrey80
    tertiary = MarsTertiary80    // Replaces Pink80
    // You may also want to set background, surface, and onColors here
)

private val LightColorScheme = lightColorScheme(
    primary = MarsPrimary40,     // Replaces Purple40
    secondary = MarsSecondary40,  // Replaces PurpleGrey40
    tertiary = MarsTertiary40     // Replaces Pink40
    // You may also want to set background, surface, and onColors here
)

@Composable
fun MarsPhotosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // Dynamic color in this app is turned off for learning purposes
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            // Use the dynamic scheme if darkTheme is on, otherwise use the dynamic light scheme
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Assuming Typography is defined elsewhere
        // shapes = Shapes, // Assuming Shapes is defined elsewhere
        content = content
    )
}