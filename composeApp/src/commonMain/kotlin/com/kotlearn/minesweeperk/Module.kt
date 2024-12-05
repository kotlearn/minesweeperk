package com.kotlearn.minesweeperk

import com.kotlearn.minesweeperk.feature.highscores.highscoresModule
import com.kotlearn.minesweeperk.feature.menu.menuModule
import com.kotlearn.minesweeperk.feature.play.playModule
import com.kotlearn.minesweeperk.feature.settings.settingsModule
import org.koin.dsl.module

val appModule = module {
    includes(
        highscoresModule,
        settingsModule,
        playModule,
        menuModule,
    )
}