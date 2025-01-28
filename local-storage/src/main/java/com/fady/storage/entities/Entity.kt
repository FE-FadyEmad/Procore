package com.fady.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entity")
data class Entity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
)
