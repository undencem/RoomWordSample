package com.undencem.roomwordsample.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * To make the Word class meaningful to a Room database, you need to create an association between
 * the class and the database using Kotlin annotations.
 * We will use specific annotations to identify how each part of this class
 * relates to an entry in the database.
 * Room uses this extra information to generate code.
 */

/**
 * Let's see what these annotations do:

@Entity(tableName = "word_table") Each @Entity class represents a SQLite table.
Annotate your class declaration to indicate that it's an entity.
You can specify the name of the table if you want it to be different from the name of the class.
This names the table "word_table".

@PrimaryKey Every entity needs a primary key.
To keep things simple, each word acts as its own primary key.

@ColumnInfo(name = "word") Specifies the name of the column in the table
if you want it to be different from the name of the member variable.
This names the column "word".

Every property that's stored in the database needs to have public visibility, which is the Kotlin default.
 */

@Entity(tableName="word_table")
class Word(
        @PrimaryKey(autoGenerate = true)val id:Int,
        @ColumnInfo(name="word")val word:String
        )