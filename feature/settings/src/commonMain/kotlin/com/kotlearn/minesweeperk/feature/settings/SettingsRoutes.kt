package com.kotlearn.minesweeperk.feature.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object Settings

fun NavGraphBuilder.settingsRoutes() {

    composable<Settings> {
        val viewModel: SettingsViewModel = koinViewModel()
        SettingsScreen(
            viewModel = viewModel,
            modifier = Modifier.fillMaxSize(),
        )
    }

}