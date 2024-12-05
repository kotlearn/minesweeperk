package com.kotlearn.minesweeperk.data.settings

import com.kotlearn.minesweeperk.data.core.dataCoreModule
import org.koin.dsl.module

val dataSettingsModule = module {

    includes(dataCoreModule)

}