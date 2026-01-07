package com.meyrforge.mypetcare.add_pet_feature.domain

import com.meyrforge.mypetcare.add_pet_feature.domain.models.Pet
import com.meyrforge.mypetcare.common.Result
import com.meyrforge.mypetcare.common.RepositoryError

interface PetRepository {
    suspend fun savePet(pet: Pet): Result<Long, RepositoryError>
    suspend fun getAllPets(): Result<List<Pet>, RepositoryError>
}