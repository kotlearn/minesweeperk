package com.kotlearn.minesweeperk.data.settings

import com.kotlearn.minesweeperk.data.core.storage.Storage
import kotlinx.coroutines.flow.Flow

interface UsernameRepository {

    val username: Flow<String>

    suspend fun updateUsername(username: String)

    data object UsernameKey : Storage.Key.StringKey("username", "Anonymous")

}