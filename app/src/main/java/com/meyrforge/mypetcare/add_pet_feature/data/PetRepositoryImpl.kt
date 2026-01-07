package com.meyrforge.mypetcare.add_pet_feature.data

import com.meyrforge.mypetcare.add_pet_feature.data.entities.toDomain
import com.meyrforge.mypetcare.add_pet_feature.data.entities.toEntity
import com.meyrforge.mypetcare.add_pet_feature.domain.PetRepository
import com.meyrforge.mypetcare.add_pet_feature.domain.models.Pet
import com.meyrforge.mypetcare.common.RepositoryError
import com.meyrforge.mypetcare.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(private val petDao: PetDao): PetRepository {

    private suspend fun <T> safeDaoCall(daoCall: suspend () -> T): Result<T, RepositoryError>
    {
        return try {
            Result.Success(withContext(Dispatchers.IO){ daoCall()})
        } catch (e: Exception) {
            Result.Error(RepositoryError.UnknownError(e.message))
        }
    }

    override suspend fun savePet(pet: Pet): Result<Long, RepositoryError> {
        return safeDaoCall {
            petDao.insertPet(pet.toEntity())
        }
    }

    override suspend fun getAllPets(): Result<List<Pet>, RepositoryError> {
         return safeDaoCall {
            petDao.getAllPets().map { it.toDomain() }
        }
    }
}