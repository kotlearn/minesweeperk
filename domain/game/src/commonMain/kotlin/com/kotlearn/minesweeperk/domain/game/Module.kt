package com.kotlearn.minesweeperk.domain.game

import com.kotlearn.minesweeper.data.game.dataGameModule
import com.kotlearn.minesweeperk.data.settings.dataSettingsModule
import org.koin.dsl.module

val domainGameModule = module {

    includes(dataSettingsModule, dataGameModule)

}