package com.kotlearn.minesweeperk.domain.settings

import com.kotlearn.minesweeperk.data.settings.UsernameRepository
import kotlinx.coroutines.flow.Flow

class GetUsernameAsFlowUseCase(
    private val usernameRepository: UsernameRepository,
) {

    operator fun invoke(): Flow<String> = usernameRepository.username

}