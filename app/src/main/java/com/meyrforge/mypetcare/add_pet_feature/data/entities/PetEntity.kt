package com.meyrforge.mypetcare.add_pet_feature.data.entities

import androidx.core.text.backgroundColor
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meyrforge.mypetcare.add_pet_feature.domain.models.Pet
import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.Species

@Entity(tableName = "pet_table")
data class PetEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val species: String,
    @ColumnInfo(name = "image_res") val imageRes: Int,
    @ColumnInfo(name = "background_color") val backgroundColor: String

)

fun Pet.toEntity(): PetEntity {
    return if (id == null) {
        PetEntity(
            name = name,
            species = species.name,
            imageRes = imageRes,
            backgroundColor = backgroundColor
        )
    } else {
        PetEntity(
            id = id,
            name = name,
            species = species.name,
            imageRes = imageRes,
            backgroundColor = backgroundColor
        )
    }
}

fun PetEntity.toDomain(): Pet {
    return Pet(
        id = id,
        name = name,
        species = if (species == "DOG") Species.DOG else Species.CAT,
        imageRes = imageRes,
        backgroundColor = backgroundColor
    )
}