package com.undencem.roomwordsample.roomdatabase

class WordRoomDatabase {
    /**
     * Add a Room database
    What is a Room database**?**

    Room is a database layer on top of an SQLite database.
    Room takes care of mundane tasks that you used to handle with an SQLiteOpenHelper.
    Room uses the DAO to issue queries to its database.
    By default, to avoid poor UI performance, Room doesn't allow you to issue queries on the main thread.
    When Room queries return Flow, the queries are automatically run asynchronously on a background thread.
    Room provides compile-time checks of SQLite statements.

    Implement the Room database

    Your Room database class must be abstract and extend RoomDatabase. Usually, you only need one instance of a Room database for the whole app.

    Let's make one now.
     */

    /**
     * Annotates class to be a Room Database with a table (entity) of the Word class
     */

}