package com.undencem.roomwordsample.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.undencem.roomwordsample.entity.Word as Word

/**
 * What is the DAO?
 *
*In the DAO (data access object), you specify SQL queries and associate them with method calls.
The compiler checks the SQL and generates queries from convenience annotations for common queries, such as @Insert.
Room uses the DAO to create a clean API for your code.

*The DAO must be an interface or abstract class.

*By default, all queries must be executed on a separate thread.

*Room has Kotlin coroutines support.
*This allows your queries to be annotated with the suspend modifier and then called
from a coroutine or from another suspension function.
Implement the DAO

*Let's write a DAO that provides queries for:

*Getting all words ordered alphabetically
*Inserting a word
*Deleting all words

*Create a new Kotlin class file called WordDao.
*Copy and paste the following code into WordDao and fix the imports as necessary to make it compile.
 */

@Dao
interface WordDao {

    /**
     * To observe data changes we will use Flow from kotlinx-coroutines.
     * Use a return value of type Flow in your method description, and
     * Room generates all necessary code to update the Flow when the database is updated.
     */
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    /**
     *
    WordDao is an interface; DAOs must either be interfaces or abstract classes.

    The @Dao annotation identifies it as a DAO class for Room.

    suspend fun insert(word: Word) : Declares a suspend function to insert one word.

    The @Insert annotation is a special DAO method annotation where you don't have to provide any SQL!

    (There are also @Delete and @Update annotations for deleting and updating rows, but you are not using them in this app.)

    onConflict = OnConflictStrategy.IGNORE: The selected onConflict strategy ignores a new word if it's exactly the same as one already in the list.
    To know more about the available conflict strategies, check out the documentation.

    suspend fun deleteAll(): Declares a suspend function to delete all the words.

    There is no convenience annotation for deleting multiple entities, so it's annotated with the generic @Query.

    @Query("DELETE FROM word_table"):
    @Query requires that you provide a SQL query as a string parameter to the annotation,
    allowing for complex read queries and other operations.

    fun getAlphabetizedWords(): List<Word>: A method to get all the words and have it return a List of Words.

    @Query("SELECT * FROM word_table ORDER BY word ASC"): Query that returns a list of words sorted in ascending order.

     */


}