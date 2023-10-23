package com.accenture.core.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.accenture.core.ui.screen.main.GitHubRepoMainViewModel
import com.accenture.core.ui.GitHubRepositoryApp
import com.accenture.core.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubRepositoryApp {
                val viewModelHilt = hiltViewModel<GitHubRepoMainViewModel>()
                Navigation(mainViewModel = viewModelHilt)
            }
        }
    }
}



