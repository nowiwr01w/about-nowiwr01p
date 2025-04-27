package about.nowiwr01p.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import about.nowiwr01p.theme.params.AppShapes
import about.nowiwr01p.theme.params.AppTypography

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(),
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}