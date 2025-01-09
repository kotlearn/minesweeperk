package com.kotlearn.minesweeperk.data.core

import com.kotlearn.minesweeperk.data.core.storage.DataStoreStorage
import com.kotlearn.minesweeperk.data.core.storage.Storage
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataCoreModule = module {
    includes(platformModule)
    singleOf(::DataStoreStorage) {
        bind<Storage>()
    }
}

internal expect val platformModule: Module
