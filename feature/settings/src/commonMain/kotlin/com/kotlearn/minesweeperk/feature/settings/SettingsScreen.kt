package com.kotlearn.minesweeperk.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun SettingsScreen(
    viewModel: SettingsViewModel,
    modifier: Modifier = Modifier
) {
    val username by viewModel.username.collectAsStateWithLifecycle()

    Column(modifier = modifier) {

        Text("Username")

        TextField(
            value = username,
            onValueChange = {
                viewModel.setUsername(it)
            }
        )

        Button(
            onClick = {
                viewModel.save()
            }
        ) {
            Text("Save")
        }

    }
}