package com.example.localnotification.domain.use_case

import com.example.localnotification.domain.model.Celebration
import com.example.localnotification.domain.repository.CelebrationRepository

class InsertCelebration(
    private val repository: CelebrationRepository
) {
    suspend operator fun invoke(celebration: Celebration){
        repository.insertCelebration(celebration = celebration)
    }
}