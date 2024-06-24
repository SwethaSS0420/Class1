package com.example.class1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class Word(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Auto-generated primary key
    @ColumnInfo(name = "word") val word: String
)

