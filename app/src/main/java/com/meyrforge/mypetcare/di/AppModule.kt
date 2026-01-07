package com.meyrforge.mypetcare.di

import android.content.Context
import androidx.room.Room
import com.meyrforge.mypetcare.add_pet_feature.data.PetDao
import com.meyrforge.mypetcare.add_pet_feature.data.PetRepositoryImpl
import com.meyrforge.mypetcare.add_pet_feature.domain.PetRepository
import com.meyrforge.mypetcare.common.data.MyPetCareDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "mypetcare_database"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MyPetCareDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun providePetDao(db: MyPetCareDatabase) = db.petDao()

    @Provides
    fun providePetRepository(petDao: PetDao): PetRepository = PetRepositoryImpl(petDao)
}