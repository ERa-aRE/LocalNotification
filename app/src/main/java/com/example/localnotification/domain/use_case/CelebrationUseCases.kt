package com.example.localnotification.domain.use_case

data class CelebrationUseCases(
    val deleteCelebration: DeleteCelebration,
    val getAllCelebration: GetAllCelebration,
    val getCelebrationByCategory: GetCelebrationByCategory,
    val getCelebrationById: GetCelebrationById,
    val insertCelebration: InsertCelebration,
)
