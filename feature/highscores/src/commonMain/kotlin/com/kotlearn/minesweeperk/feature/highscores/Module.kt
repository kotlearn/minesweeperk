package com.kotlearn.minesweeperk.feature.highscores

import com.kotlearn.minesweeperk.domain.game.domainGameModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val highscoresModule = module {

    includes(domainGameModule)

    viewModelOf(::HighscoresViewModel)

}
