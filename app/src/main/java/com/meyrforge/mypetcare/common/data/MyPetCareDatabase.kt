package com.meyrforge.mypetcare.common.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meyrforge.mypetcare.add_pet_feature.data.PetDao
import com.meyrforge.mypetcare.add_pet_feature.data.entities.PetEntity

@Database(version = 1, entities = [PetEntity::class], exportSchema = true)
abstract class MyPetCareDatabase : RoomDatabase() {
    abstract fun petDao(): PetDao
}