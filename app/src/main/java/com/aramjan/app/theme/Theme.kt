package com.aramjan.app.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryTeal,
    secondary = LightMint,
    tertiary = TerracottaRed,
    background = BgWarm,
    surface = BgWarm
)

@Composable
fun AramJanTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
