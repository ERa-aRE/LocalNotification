package com.example.localnotification.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.localnotification.domain.model.Celebration


@Database(entities = [Celebration::class], version = 1)
abstract class CelebrationDB:RoomDatabase() {
    abstract val celebrationDao: CelebrationDao
    companion object{
        const val DATABASE_NAME="celebration_db"
    }
}