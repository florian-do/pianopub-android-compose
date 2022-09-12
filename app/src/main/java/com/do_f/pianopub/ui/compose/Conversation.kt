package com.do_f.pianopub.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.do_f.pianopub.model.Message
import com.do_f.pianopub.ui.theme.PianopubTheme
import com.do_f.pianopub.utils.SampleData

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->  
            MessageCard(message = message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    PianopubTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}