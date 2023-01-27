package com.example.localnotification.data.data_source

import androidx.room.*
import com.example.localnotification.domain.model.Celebration
import kotlinx.coroutines.flow.Flow


@Dao
interface CelebrationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCelebration(celebration: Celebration)
    @Delete
    suspend fun deleteCelebration(celebration: Celebration)
    @Query("SELECT * FROM celebration  WHERE category= :category")
    fun getCelebrationsByCategory(category:String): Flow<List<Celebration>>

    @Query("SELECT * FROM celebration WHERE id = :id")
    suspend fun getCelebrationById(id:Int):Celebration?

    @Query("SELECT * FROM celebration")
    fun getAllCelebrations():Flow<List<Celebration>>
}