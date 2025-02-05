package com.kotlearn.minesweeperk.feature.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kotlearn.minesweeperk.ui.core.LocalDimensions
import com.kotlearn.minesweeperk.ui.core.LocalPadding

@Composable
internal fun MenuScreen(
    goToPlay: () -> Unit,
    goToHighscores: () -> Unit,
    goToSettings: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        val buttonModifier = Modifier
            .padding(horizontal = LocalPadding.current.normal)
            .widthIn(max = LocalDimensions.current.maxWidthSmall)
            .fillMaxWidth()
        MenuButton(
            text = "Play",
            onClick = goToPlay,
            modifier = buttonModifier,
        )
        MenuButton(
            text = "Highscores",
            onClick = goToHighscores,
            modifier = buttonModifier,
        )
        MenuButton(
            text = "Settings",
            onClick = goToSettings,
            modifier = buttonModifier,
        )
    }
}