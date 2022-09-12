package com.do_f.pianopub.ui.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.do_f.pianopub.R
import com.do_f.pianopub.model.Message
import com.do_f.pianopub.ui.theme.PianopubTheme

@Composable
fun MessageCard(message: Message) {
    Row(Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_account_circle_24),
            contentDescription = "",
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(4.dp))

        var isExpended by remember {
            mutableStateOf(false)
        }
        Column(modifier = Modifier.clickable {
            isExpended = !isExpended
        }) {
            Text(text = message.name, color = MaterialTheme.colorScheme.secondary)
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpended) 99 else 1,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview
@Composable
fun PreviewCardMessage() {
    PianopubTheme {
        Surface {
            MessageCard(message = Message(
                    name = "slt",
                    body = "123456781234567812345678123"
                )
            )
        }
    }
}