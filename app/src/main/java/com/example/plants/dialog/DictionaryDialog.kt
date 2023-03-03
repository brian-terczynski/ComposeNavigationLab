package com.example.plants.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DictionaryDialog(term: String, definition: String) {
    val openDialog = remember { mutableStateOf(true) }
    val dialogWidth = 200.dp

    if (openDialog.value) {
        Dialog(onDismissRequest = {
            openDialog.value = false
            // TODO: Hint, you might need to do something here too.
        }) {
            Column(
                Modifier
                    .width(dialogWidth)
                    .background(Color.White)
            ) {
                Text(term)
                Text(definition)
                Button(onClick = {
                    // TODO: Fill this in
                }) {
                    Text("Ok")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDictionaryDialog() {
    DictionaryDialog(term = "Term", definition = "Definition")
}
