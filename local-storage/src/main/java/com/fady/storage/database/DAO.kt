package com.fady.storage.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fady.storage.entities.Entity

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Entity>)

    @Delete
    suspend fun delete(entity: Entity)

    @Query("SELECT * FROM entity")
    suspend fun getAll(): List<Entity>
}
