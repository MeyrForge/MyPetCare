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
        PetPicture(5, R.drawable.eight, Species.DOG),
        PetPicture(6, R.drawable.ten, Species.DOG),
        PetPicture(7, R.drawable.twelve, Species.CAT),
        PetPicture(8, R.drawable.five, Species.DOG),
        PetPicture(9, R.drawable.seven, Species.DOG),
        PetPicture(10, R.drawable.six, Species.DOG),
        PetPicture(11, R.drawable.eleven, Species.CAT),
        PetPicture(12, R.drawable.thirteen, Species.CAT),
        PetPicture(13, R.drawable.fifteen, Species.CAT),
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

object SpeciesProvider {
    val speciesTranslated = listOf(
        "Perro" to Species.DOG,
        "Gato" to Species.CAT
    )
}