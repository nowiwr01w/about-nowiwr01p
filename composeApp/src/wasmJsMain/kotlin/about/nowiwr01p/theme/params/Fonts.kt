package about.nowiwr01p.theme.params

import about_me.composeapp.generated.resources.JetBrainsMono_Bold
import about_me.composeapp.generated.resources.JetBrainsMono_ExtraBold
import about_me.composeapp.generated.resources.JetBrainsMono_Medium
import about_me.composeapp.generated.resources.JetBrainsMono_Regular
import about_me.composeapp.generated.resources.JetBrainsMono_SemiBold
import about_me.composeapp.generated.resources.Res
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font

val JetBrainsMono @Composable get() = FontFamily(
    Font(Res.font.JetBrainsMono_Regular, FontWeight.Normal),
    Font(Res.font.JetBrainsMono_Bold, FontWeight.Bold),
    Font(Res.font.JetBrainsMono_ExtraBold, FontWeight.ExtraBold),
    Font(Res.font.JetBrainsMono_Medium, FontWeight.Medium),
    Font(Res.font.JetBrainsMono_SemiBold, FontWeight.SemiBold),
)