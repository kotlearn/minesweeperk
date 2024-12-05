package com.kotlearn.minesweeperk.feature.highscores

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun HighscoresScreen(
    viewModel: HighscoresViewModel,
    modifier: Modifier = Modifier
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        Text(text = viewModel.title)
    }

}