package com.dgu.camputhon.domain.usecase

import com.dgu.camputhon.domain.repository.ShortsRepository
import javax.inject.Inject

class PostCreateUserUseCase @Inject constructor(private val shortsRepository: ShortsRepository) {

    suspend operator fun invoke(uuid: String, sex: String) =
        shortsRepository.postCreateUser(uuid, sex)
}