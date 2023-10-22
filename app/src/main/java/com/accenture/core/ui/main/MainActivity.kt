package com.accenture.core.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.accenture.core.ui.GitHubRepoViewModel
import com.accenture.core.ui.GitHubRepositoryApp
import com.accenture.core.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: GitHubRepoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubRepositoryApp {
                Navigation(mainViewModel = viewModel)
            }
        }
    }
}



