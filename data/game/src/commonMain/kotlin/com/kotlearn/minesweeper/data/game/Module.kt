package com.kotlearn.minesweeper.data.game

import com.kotlearn.minesweeperk.data.core.dataCoreModule
import org.koin.dsl.module

val dataGameModule = module {

    includes(dataCoreModule)

}