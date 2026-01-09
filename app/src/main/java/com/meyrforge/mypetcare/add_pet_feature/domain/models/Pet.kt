package com.meyrforge.mypetcare.add_pet_feature.domain.models

import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.Species

data class Pet(
    val id: Int?,
    val name: String,
    val species: Species,
    val imageRes: Int,
    val backgroundColor: String
)
