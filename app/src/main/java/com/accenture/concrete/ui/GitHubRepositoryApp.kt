package com.accenture.concrete.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.accenture.concrete.ui.theme.AccentureGoTheme

@Composable
fun  GitHubRepositoryApp (content: @Composable () -> Unit) {
    AccentureGoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}