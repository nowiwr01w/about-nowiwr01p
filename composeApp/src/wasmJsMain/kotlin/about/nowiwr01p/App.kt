package about.nowiwr01p

import about.nowiwr01p.Contact.Email
import about.nowiwr01p.Contact.GitHub
import about.nowiwr01p.Contact.LinkedIn
import about.nowiwr01p.Contact.Telegram
import about.nowiwr01p.theme.AppTheme
import about.nowiwr01p.theme.params.colorBackground
import about.nowiwr01p.theme.params.colorBackgroundLight
import about.nowiwr01p.theme.params.colorText
import about_me.composeapp.generated.resources.Res
import about_me.composeapp.generated.resources.moonlight_square
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun App() {
    AppTheme {
        Content()
    }
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
        Spacer(modifier = Modifier.weight(1f))
        ContactsFooter()
    }
}

@Composable
private fun ColumnScope.Avatar() {
    Image(
        painter = painterResource(Res.drawable.moonlight_square),
        contentDescription = null,
        modifier = Modifier
            .size(289.dp)
            .clip(CircleShape)
    )
}

@Composable
private fun Name() {
    Text(
        text = "Andrey Larionov",
        style = MaterialTheme.typography.h1,
        color = colorText,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
private fun ContactsFooter() {
    val shape = remember { RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp)
            .clip(shape)
            .background(
                color = colorBackgroundLight,
                shape = shape
            )
    ) {
        Contacts()
    }
}

@Composable
private fun Contacts() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(0.66f)
    ) {
        contacts.forEach { contact ->
            ContactItem(
                contact = contact,
                onContactClick = {
                    if (contact is Email) {
                        window.location.href = contact.url
                    } else {
                        window.open(contact.url, "_blank")
                    }
                }
            )
        }
    }
}

@Composable
private fun ContactItem(
    contact: Contact,
    onContactClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onContactClick() }
    ) {
        Text(
            text = contact.label.uppercase(),
            color = colorText,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}

private sealed class Contact(
    val label: String,
    val url: String
) {
    data object Telegram: Contact("Telegram", "https://t.me/nowiwr01p")
    data object LinkedIn: Contact("LinkedIn", "https://www.linkedin.com/in/nowiwr01w/")
    data object GitHub: Contact("GitHub", "https://github.com/nowiwr01w")
    data object Email: Contact("Email", "mailto:nowiwr01p@pm.me")
}

private val contacts = listOf(Telegram, LinkedIn, GitHub, Email)