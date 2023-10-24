package com.accenture.core.ui.screen.details.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TopBarDetail(title : String , onUpClick: () -> Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onUpClick()}
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(25.dp)
            )
        }

        Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .weight(1.0f),
            textAlign = TextAlign.Center
        )

    }
}