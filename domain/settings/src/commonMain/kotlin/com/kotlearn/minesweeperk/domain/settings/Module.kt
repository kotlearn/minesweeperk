package com.kotlearn.minesweeperk.domain.settings

import com.kotlearn.minesweeperk.data.settings.dataSettingsModule
import org.koin.dsl.module

val domainSettingsModule = module {

    includes(dataSettingsModule)

}