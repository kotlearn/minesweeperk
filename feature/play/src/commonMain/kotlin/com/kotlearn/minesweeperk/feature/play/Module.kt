package com.kotlearn.minesweeperk.feature.play

import com.kotlearn.minesweeperk.domain.game.domainGameModule
import org.koin.dsl.module

val playModule = module {

    includes(domainGameModule)

}