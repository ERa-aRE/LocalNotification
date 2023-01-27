package com.example.localnotification.domain.use_case

import com.example.localnotification.domain.model.Celebration
import com.example.localnotification.domain.repository.CelebrationRepository
import kotlinx.coroutines.flow.Flow

class GetCelebrationByCategory(private val repository: CelebrationRepository) {
    operator fun invoke(category:String):Flow<List<Celebration>>{
        return repository.getCelebrationsByCategory(category=category)
    }
}