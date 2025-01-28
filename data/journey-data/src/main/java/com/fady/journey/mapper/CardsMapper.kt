package com.fady.journey.mapper

import com.fady.journey.model.CardDataModel
import com.fady.journey.model.CardDomainModel
import com.fady.journey.model.CardImageDataModel
import com.fady.journey.model.CardImageDomainModel

fun CardDataModel.toDomainModel() =
    CardDomainModel(
        id = this.id,
        name = this.name,
        images = this.images.toDomainModel(),
    )

fun CardImageDataModel.toDomainModel() =
    CardImageDomainModel(
        small = this.small,
        large = this.large,
    )
