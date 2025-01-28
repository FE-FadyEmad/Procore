package com.fady.journey.usecases

import com.fady.journey.model.CardDomainModel
import com.fady.journey.repos.CardRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCardsUseCase
    @Inject
    constructor(
        private val repo: CardRepo,
    ) {
        operator fun invoke() =
            flow<List<CardDomainModel>> {
                emit(repo.getCards())
            }
    }
