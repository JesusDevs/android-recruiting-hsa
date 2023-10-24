package com.accenture.core.ui.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.accenture.core.ui.screen.details.component.TopBarDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    repoName: String?,
    onUpClick: () -> Boolean
) {
    Scaffold(
        topBar = { TopBarDetail(
            title = repoName ?: "",
            onUpClick = onUpClick)
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = repoName ?: "", color = MaterialTheme.colorScheme.onBackground)
            }
        }

    }

}


