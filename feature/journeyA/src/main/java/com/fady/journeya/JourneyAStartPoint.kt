package com.fady.journeya

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.fady.ui.base.BaseViewState
import com.fady.ui.components.Loading

@Composable
fun JourneyAStartPoint(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<CardViewModel>()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.getCards()
    }

    when (state) {
        BaseViewState.Loading -> {
            Loading()
        }

        is BaseViewState.WithData -> {
            val data = (state as BaseViewState.WithData<CardUiState>).data.list.orEmpty()
            DrawListOfImages(list = data)
        }

        is BaseViewState.Error -> {}
        BaseViewState.Idle -> {}
    }
}

@Composable
fun DrawListOfImages(
    list: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(list) { url ->
            AsyncImage(
                model = url,
                contentDescription = "Image",
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
