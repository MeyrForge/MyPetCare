package com.meyrforge.mypetcare.add_pet_feature.domain.usecases

import com.meyrforge.mypetcare.add_pet_feature.domain.PetRepository
import com.meyrforge.mypetcare.add_pet_feature.domain.models.Pet
import com.meyrforge.mypetcare.add_pet_feature.presentation.utils.Species
import com.meyrforge.mypetcare.common.RepositoryError
import com.meyrforge.mypetcare.common.Result
import javax.inject.Inject

class AddPetUsecase @Inject constructor(private val repository: PetRepository) {
    suspend operator fun invoke(
        name: String,
        species: Species,
        imageRes: Int,
        backgroundColor: String
    ): Result<Long, RepositoryError> {
        return repository.savePet(
            Pet(
                id = null,
                name = name,
                species = species,
                imageRes = imageRes,
                backgroundColor = backgroundColor
            )
        )
    }

}