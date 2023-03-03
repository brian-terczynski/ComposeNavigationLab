package com.example.plants.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plants.R
import com.example.plants.model.Plant
import com.example.plants.viewmodels.DetailScreenViewModel
import com.example.plants.viewmodels.MainScreenViewModel
import java.util.*

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel,
    id: Int?,
    name: String?,
) {
    // TODO: Do something with the ViewModel here to get its data
    DetailScreenContents(null, 0) {
        // TODO: Do something when we hit the like button
    }
}

@Composable
private fun DetailScreenContents(
    plant: Plant?,
    numLikes: Int,
    onLikeClicked: () -> Unit,
) {
    plant?.let {
        Column(modifier = Modifier.background(Color.White)) {
            Image(
                painter = painterResource(id = plant.imageId),
                contentDescription = plant.name,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )
            Text(text = it.name.capitalize(Locale.current))
            val annotatedText = buildAnnotatedString {
                plant.description.split("--").forEach { substring ->
                    if (substring.startsWith("[L]")) {
                        val text = substring.substring(3)
                        pushStringAnnotation(tag = "link", text)
                        withStyle(
                            SpanStyle(
                                color = Color.Blue
                            )
                        ) {
                            append(text)
                        }
                        pop()
                    } else if (substring.startsWith("[D]")) {
                        val text = substring.substring(3)
                        pushStringAnnotation(tag = "dict", text)
                        withStyle(
                            SpanStyle(
                                color = Color.Blue
                            )
                        ) {
                            append(text)
                        }
                        pop()
                    } else {
                        append(substring)
                    }
                }
            }
            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    annotatedText.getStringAnnotations(
                        tag = "link", start = offset, end = offset
                    ).firstOrNull()?.let { annotation ->
                        // TODO: Put in click action to go to Details screen
                        // using the name of the plant
                    }
                    annotatedText.getStringAnnotations(
                        tag = "dict", start = offset, end = offset
                    ).firstOrNull()?.let { annotation ->
                        // TODO: Go to dialog that shows the definition of the word.
                    }
                }
            )
            Button(onClick = onLikeClicked) {
                Text("Like ($numLikes)")
            }
            Button(onClick = { /* TODO: to back to MainScreen */ }) {
                Text("Go To Main Screen")
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreenContents(
        Plant(
            id = 55732,
            name = "azalea",
            description = """
                Azaleas are flowering --[L]shrub--s in the genus Rhododendron, particularly the
                former sections Tsutsusi (evergreen) and Pentanthera --[D]deciduous--. Azaleas bloom in
                the spring (April and May in the temperate Northern Hemisphere, and October and
                November in the Southern Hemisphere), their flowers often lasting several weeks.
                Shade tolerant, they prefer living near or under trees. They are part of the family
                Ericaceae.
            """.trimIndent(),
            imageId = R.drawable.azalea,
        ),
        numLikes = 3,
    ) {}
}
