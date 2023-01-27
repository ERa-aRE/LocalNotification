package com.example.localnotification.di

import android.app.Application
import androidx.room.Room
import com.example.localnotification.data.data_source.CelebrationDB
import com.example.localnotification.data.data_source.CelebrationDao
import com.example.localnotification.data.repository.CelebrationRepositoryImpl
import com.example.localnotification.domain.repository.CelebrationRepository
import com.example.localnotification.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCelebrationDB(app:Application):CelebrationDB{
        return Room.databaseBuilder(
            app,
            CelebrationDB::class.java,
            CelebrationDB.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCelebrationRepository(db:CelebrationDB):CelebrationRepository{
        return CelebrationRepositoryImpl(db.celebrationDao)
    }
    @Provides
    @Singleton
    fun provideCelebrationUseCase(repository: CelebrationRepository):CelebrationUseCases{
        return CelebrationUseCases(
            getAllCelebration = GetAllCelebration(repository),
            getCelebrationByCategory = GetCelebrationByCategory(repository),
            getCelebrationById = GetCelebrationById(repository),
            deleteCelebration = DeleteCelebration(repository),
            insertCelebration = InsertCelebration(repository)
        )
    }
}