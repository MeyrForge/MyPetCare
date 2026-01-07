package com.meyrforge.mypetcare.add_pet_feature.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.meyrforge.mypetcare.add_pet_feature.data.entities.PetEntity

@Dao
interface PetDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertPet(pet: PetEntity) : Long

    @Transaction
    @Query("SELECT * FROM pet_table")
    suspend fun getAllPets(): List<PetEntity>

    @Transaction
    @Update
    suspend fun updatePet(pet: PetEntity) : Long

    @Transaction
    @Query("DELETE FROM pet_table WHERE id = :petId")
    suspend fun deletePet(petId: Int) : Long

    @Transaction
    @Query("SELECT * FROM pet_table WHERE id = :petId")
    suspend fun getPetById(petId: Int): PetEntity?

}