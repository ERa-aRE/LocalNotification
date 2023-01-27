package com.example.localnotification.domain.repository


import com.example.localnotification.domain.model.Celebration
import kotlinx.coroutines.flow.Flow

interface CelebrationRepository {

    suspend fun insertCelebration(celebration: Celebration)

    suspend fun deleteCelebration(celebration: Celebration)

    fun getCelebrationsByCategory(category:String): Flow<List<Celebration>>

    suspend fun getCelebrationById(id:Int): Celebration?

    fun getAllCelebrations(): Flow<List<Celebration>>
}