package about.nowiwr01p.theme.params

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

val AppTypography @Composable get() = Typography(
    h1 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp,
        lineHeight = 36.sp,
        lineHeightStyle = lineHeightStyle
    ),
    h2 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 28.sp,
        lineHeightStyle = lineHeightStyle
    ),
    h3 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        lineHeightStyle = lineHeightStyle
    ),
    h4 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        lineHeightStyle = lineHeightStyle
    ),
    h5 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
    h6 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        lineHeightStyle = lineHeightStyle
    ),
    body1 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),
    body2 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subtitle1 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subtitle2 = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        lineHeightStyle = lineHeightStyle
    ),
    button = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
    caption = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        lineHeightStyle = lineHeightStyle
    ),
    overline = TextStyle(
        fontFamily = JetBrainsMono,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        lineHeightStyle = lineHeightStyle
    )
)

private val lineHeightStyle get() = LineHeightStyle(
    trim = LineHeightStyle.Trim.None,
    alignment = LineHeightStyle.Alignment.Center
)