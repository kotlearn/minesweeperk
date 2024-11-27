package com.kotlearn.minesweeperk

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kotlearn.minesweeperk.feature.menu.MenuScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        MenuScreen(
            goToPlay = {

            },
            goToHighscores = { },
            goToSettings = { },
            modifier = Modifier.fillMaxSize(),
        )
    }
}