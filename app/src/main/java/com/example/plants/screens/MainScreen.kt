package com.example.plants.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plants.R
import com.example.plants.model.Plant
import com.example.plants.repository.PlantRepository
import com.example.plants.viewmodels.MainScreenViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    // TODO: Do something with the ViewModel here to get its data
    MainScreenContents(emptyList()) // TODO: Get from ViewModel
}

@Composable
private fun MainScreenContents(plants: List<Plant>) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        items(plants) {
            Text(
                text = it.name,
                modifier = Modifier
                    .padding(24.dp)
                    .clickable {
                        // TODO: Fill this in
                    }
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreenContents(
        listOf(
            Plant(1, "Plant1", "desc", R.drawable.hibiscus),
            Plant(2, "Plant2", "desc", R.drawable.hibiscus),
        ),
    )
}