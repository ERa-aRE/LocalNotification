package com.example.localnotification.data.repository

import com.example.localnotification.data.data_source.CelebrationDao
import com.example.localnotification.domain.model.Celebration
import com.example.localnotification.domain.repository.CelebrationRepository
import kotlinx.coroutines.flow.Flow

class CelebrationRepositoryImpl(
    private val dao: CelebrationDao
) : CelebrationRepository {
    override suspend fun insertCelebration(celebration: Celebration) {
        dao.insertCelebration(celebration = celebration)
    }

    override suspend fun deleteCelebration(celebration: Celebration) {
        dao.deleteCelebration(celebration = celebration)
    }

    override fun getCelebrationsByCategory(category: String): Flow<List<Celebration>> {
        return dao.getCelebrationsByCategory(category=category)
    }

    override suspend fun getCelebrationById(id: Int): Celebration? {
        return dao.getCelebrationById(id=id)
    }

    override fun getAllCelebrations(): Flow<List<Celebration>> {
        return dao.getAllCelebrations()
    }
}