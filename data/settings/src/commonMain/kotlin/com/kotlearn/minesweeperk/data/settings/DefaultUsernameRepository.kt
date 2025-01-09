package com.kotlearn.minesweeperk.data.settings

import com.kotlearn.minesweeperk.data.core.storage.Storage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DefaultUsernameRepository(
    private val storage: Storage,
) : UsernameRepository {

    override val username: Flow<String> = storage.getAsFlow(UsernameRepository.UsernameKey)
        .map { it.orEmpty() }

    override suspend fun updateUsername(username: String) {
        storage.writeValue(UsernameRepository.UsernameKey, username)
    }
}