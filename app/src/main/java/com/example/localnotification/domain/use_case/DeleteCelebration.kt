package com.example.localnotification.domain.use_case

import com.example.localnotification.domain.model.Celebration
import com.example.localnotification.domain.repository.CelebrationRepository

class DeleteCelebration(
    private val repository: CelebrationRepository
) {
    suspend operator fun invoke(celebration:Celebration){
        repository.deleteCelebration(celebration = celebration)
    }
}