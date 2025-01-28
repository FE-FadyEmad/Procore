package com.fady.journeya

import com.fady.journey.usecases.GetCardsUseCase
import com.fady.ui.base.BaseViewModel
import com.fady.ui.base.BaseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class CardViewModel
    @Inject
    constructor(
        private val useCase: GetCardsUseCase,
    ) : BaseViewModel<CardUiState>() {
        fun getCards() {
            useCase()
                .onStart {
                    setState(BaseViewState.Loading)
                }.onEach { card ->
                    val data = card.map { it.images.small }
                    setState(BaseViewState.WithData(CardUiState(data)))
                }.launchIn(coroutinesScope())
        }
    }
