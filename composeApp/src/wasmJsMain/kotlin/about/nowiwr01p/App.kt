package about.nowiwr01p

import about.nowiwr01p.Contact.Email
import about.nowiwr01p.Contact.GitHub
import about.nowiwr01p.Contact.LinkedIn
import about.nowiwr01p.Contact.Telegram
import about.nowiwr01p.WindowMode.Desktop
import about.nowiwr01p.WindowMode.Mobile
import about.nowiwr01p.core_ui.extensions.getScreenHeight
import about.nowiwr01p.core_ui.extensions.getScreenWidth
import about.nowiwr01p.core_ui.theme.AppTheme
import about.nowiwr01p.core_ui.theme.params.colorAccent
import about.nowiwr01p.core_ui.theme.params.colorAccentSecondary
import about.nowiwr01p.core_ui.theme.params.colorBackground
import about.nowiwr01p.core_ui.theme.params.colorBackgroundLight
import about.nowiwr01p.core_ui.theme.params.colorText
import about_me.composeapp.generated.resources.Res
import about_me.composeapp.generated.resources.ic_email
import about_me.composeapp.generated.resources.ic_github
import about_me.composeapp.generated.resources.ic_linkedin
import about_me.composeapp.generated.resources.ic_telegram
import about_me.composeapp.generated.resources.moonlight_square
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import kotlinx.browser.window
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.w3c.dom.events.Event

@Composable
fun App() {
    val mode = rememberWindowMode()
    CompositionLocalProvider(LocalWindowMode provides mode) {
        AppTheme {
            Content()
        }
    }
}

/**
 * WINDOW MODE
 */
private const val MOBILE_BREAKPOINT = 650

enum class WindowMode {
    Desktop,
    Mobile
}

private val LocalWindowMode = staticCompositionLocalOf<WindowMode> {
    error("WindowMode not provided")
}

@Composable
fun rememberWindowMode(): WindowMode {
    val width = remember { mutableStateOf(window.innerWidth) }
    DisposableEffect(Unit) {
        val listener: (Event) -> Unit = { width.value = window.innerWidth }
        window.addEventListener("resize", listener)
        onDispose {
            window.removeEventListener("resize", listener)
        }
    }
    return if (width.value < MOBILE_BREAKPOINT) Mobile else Desktop
}


@Composable
private fun Content() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorBackground)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Avatar()
        Name()
        SupportButton()
        Spacer(modifier = Modifier.weight(1f))
        ContactsFooter()
    }
}

/**
 * AVATAR
 */
@Composable
private fun ColumnScope.Avatar() {
    val desiredImageSize = 289.dp
    val possibleImageSize = getScreenWidth() * 0.5f
    val avatarSize = min(desiredImageSize, possibleImageSize)
    Image(
        painter = painterResource(Res.drawable.moonlight_square),
        contentDescription = null,
        modifier = Modifier
            .size(avatarSize)
            .clip(CircleShape)
    )
}

/**
 * NAME
 */
@Composable
private fun Name() {
    BasicText(
        text = "Andrey Larionov",
        style = MaterialTheme.typography.h1.copy(
            color = colorText,
            textAlign = TextAlign.Center
        ),
        autoSize = TextAutoSize.StepBased(
            minFontSize = MaterialTheme.typography.h4.fontSize,
            maxFontSize = MaterialTheme.typography.h1.fontSize,
            stepSize = 2.sp
        ),
        maxLines = 2,
        modifier = Modifier
            .padding(top = 16.dp, start = 48.dp, end = 48.dp)
            .fillMaxWidth()
    )
}

/**
 * CONTACTS
 */
@Composable
private fun ContactsFooter() {
    val shape = remember { RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp) }
    val desiredHeight = getScreenHeight() * 0.2f
    val contactsFooterHeight = min(desiredHeight, 128.dp)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(contactsFooterHeight)
            .clip(shape)
            .background(
                color = colorBackgroundLight,
                shape = shape
            )
    ) {
        Contacts(contactsFooterHeight)
    }
}

@Composable
private fun Contacts(contactsFooterHeight: Dp) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(0.75f)
    ) {
        contacts.forEach { contact ->
            ContactItem(
                contact = contact,
                contactsFooterHeight = contactsFooterHeight,
                onContactClick = {
                    if (contact is Email) {
                        window.location.href = contact.link
                    } else {
                        window.open(contact.link, "_blank")
                    }
                }
            )
        }
    }
}

@Composable
private fun ContactItem(
    contact: Contact,
    contactsFooterHeight: Dp,
    onContactClick: () -> Unit
) {
    val mode = LocalWindowMode.current
    val shape = if (mode == Mobile) CircleShape else RoundedCornerShape(16.dp)
    val containerHeight = contactsFooterHeight * 0.6f
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(containerHeight)
            .clip(shape)
            .clickable { onContactClick() }
    ) {
        when (mode) {
            Desktop -> Text(
                text = contact.label.uppercase(),
                color = colorText,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Mobile -> {
                val imageSize = contactsFooterHeight / 3
                val imageHorizontalPadding = containerHeight - imageSize
                Image(
                    painter = painterResource(contact.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(CircleShape)
                        .padding(imageHorizontalPadding / 2)
                )
            }
        }
    }
}

private sealed class Contact(
    val label: String,
    val icon: DrawableResource,
    val link: String
) {
    data object Telegram: Contact(
        label = "Telegram",
        icon = Res.drawable.ic_telegram,
        link = "https://t.me/nowiwr01p"
    )
    data object LinkedIn: Contact(
        label = "LinkedIn",
        icon = Res.drawable.ic_linkedin,
        link = "https://www.linkedin.com/in/nowiwr01w/"
    )
    data object GitHub: Contact(
        label = "GitHub",
        icon = Res.drawable.ic_github,
        link = "https://github.com/nowiwr01w"
    )
    data object Email: Contact(
        label = "Email",
        icon = Res.drawable.ic_email,
        link = "mailto:nowiwr01p@pm.me"
    )
}

private val contacts = listOf(Telegram, LinkedIn, GitHub, Email)

/**
 * SUPPORT
 */
@Composable
private fun SupportButton() {
    val widthMultiplier by animateFloatAsState(
        animationSpec = tween(),
        targetValue = if (LocalWindowMode.current == Mobile) 0.75f else 0.5f
    )
    Column(
        modifier = Modifier.padding(vertical = 24.dp)
    ) {
        AppButton(
            text = "Support",
            onClick = { window.open("https://linktr.ee/nowiwr01p", "_blank") },
            modifier = Modifier.fillMaxWidth(widthMultiplier)
        )
        AppButton(
            text = "Schedule a meeting",
            onClick = { window.open("https://calendly.com/nowiwr01p", "_blank") },
            backgroundColor = colorAccentSecondary,
            modifier = Modifier
                .fillMaxWidth(widthMultiplier)
                .padding(top = 16.dp)
        )
    }
}

@Composable
private fun AppButton(
    text: String,
    shape: Shape = RoundedCornerShape(16.dp),
    backgroundColor: Color = colorAccent,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(56.dp)
            .clip(shape = shape)
            .background(
                color = backgroundColor,
                shape = shape
            )
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            color = colorText,
            style = MaterialTheme.typography.h5
        )
    }
}