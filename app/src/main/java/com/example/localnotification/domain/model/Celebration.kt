package com.example.localnotification.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Celebration(
    @PrimaryKey val id: Int,
    val name: String,
    val day: Int,
    val month: Int,
    val year: Int,
    val day3: Int,
    val month3: Int,
    val comment: String? = null,
    val category: String,
) {
    companion object {
        val celebrationsCategory = listOf(
            "Romantic", "Birthday", "SpecialEvents", "WorkEvents", "FamilyReunions"
        )
    }
}
