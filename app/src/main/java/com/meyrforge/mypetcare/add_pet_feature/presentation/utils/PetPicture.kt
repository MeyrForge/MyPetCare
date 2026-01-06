package com.meyrforge.mypetcare.add_pet_feature.presentation.utils

import androidx.compose.ui.graphics.Color
import com.meyrforge.mypetcare.R
import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.PetDataProvider.petPictures
import com.meyrforge.mypetcare.ui.theme.pastelBlue
import com.meyrforge.mypetcare.ui.theme.pastelGreen
import com.meyrforge.mypetcare.ui.theme.pastelPink
import com.meyrforge.mypetcare.ui.theme.pastelYellow

data class PetPicture(val id: Int, val imageRes: Int, val species: Species)
enum class Species { DOG, CAT }

object PetDataProvider {
    val petPictures = listOf(
        PetPicture(1, R.drawable.four, Species.DOG),
        PetPicture(2, R.drawable.nine, Species.DOG),
        PetPicture(3, R.drawable.fourteen, Species.CAT),
        PetPicture(4, R.drawable.sixteen, Species.CAT),
    )
}

fun getPicturesBySpecies(species: Species): List<PetPicture> {
    return petPictures.filter { it.species == species }
}

data class BackgroundColor(val name: String, val color: Color)
object BackgroundColorProvider {
    val backgroundColors = listOf(
        BackgroundColor("Yellow", pastelYellow),
        BackgroundColor("Pink", pastelPink),
        BackgroundColor("Blue", pastelBlue),
        BackgroundColor("Green", pastelGreen),
    )
}