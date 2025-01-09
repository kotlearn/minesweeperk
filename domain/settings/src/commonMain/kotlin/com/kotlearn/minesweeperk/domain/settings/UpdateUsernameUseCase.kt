package com.kotlearn.minesweeperk.domain.settings

import com.kotlearn.minesweeperk.data.settings.UsernameRepository

class UpdateUsernameUseCase(
    private val usernameRepository: UsernameRepository,
) {

    suspend operator fun invoke(username: String) {
        usernameRepository.updateUsername(username)
    }

}