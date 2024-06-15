package com.accenture.core.ui.screen.home.items


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.preview.GitHubRepositoryApp

@Composable
fun GitHubRepositoryItem(
    repo: Item,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            repo.owner?.avatarUrl?.let {
            AsyncImage(
                model = repo.owner.avatarUrl,
                contentDescription = repo.name,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
            )}?: kotlin.run {
                AsyncImage(
                    model = "https://picsum.photos/200/300?random=1",
                    contentDescription = repo.name,
                    modifier = Modifier
                        .weight(1f)
                        .height(150.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = repo.name?:"No name",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = repo.description?:"No description",
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = repo.pullsUrl?:"No pulls",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = " in ${repo.cloneUrl?:"No clone url"}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 8.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    GitHubRepositoryApp {
        val repo = Item(
            id = 1,
            name = "Item 1",
            description = "Description 1",
            cloneUrl = "",
        )
        GitHubRepositoryItem(repo = repo,
            onClick = {  })
    }

}
