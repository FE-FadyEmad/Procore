package com.fady.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fady.storage.entities.Entity

@Database(entities = [Entity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): DAO
}