Whole information is copied from Google Android Devevlopment - Kotlin Labs

# RoomWordSample
Android Room with a View -Kotlin (Google codelabs Preview)

Before you begin

The purpose of Architecture Components is to provide guidance on app architecture, with libraries for common tasks like lifecycle management and data persistence. Architecture components help you structure your app in a way that is robust, testable, and maintainable with less boilerplate code. The Architecture Component libraries are part of Android Jetpack.

This is the Kotlin version of the codelab. The version in the Java programming language can be found here.

If you run into any issues (code bugs, grammatical errors, unclear wording, etc.) as you work through this codelab, please report the issue via the Report a mistake link in the lower left corner of the codelab.
Prerequisites

You need to be familiar with Kotlin, object-oriented design concepts, and Android development fundamentals, in particular:

    RecyclerView and adapters
    SQLite database and the SQLite query language
    Basic coroutines (If you're not familiar with coroutines, you can go through Using Kotlin Coroutines in your Android App.)

It also helps to be familiar with software architectural patterns that separate data from the user interface, such as Model-View-Presenter (MVP) or Model-View-Controller (MVC). This codelab implements the architecture defined in the Guide to app architecture.

This codelab is focused on Android Architecture Components. Off-topic concepts and code are provided for you to simply copy and paste.

If you are not familiar with Kotlin, a version of this codelab is provided in the Java programming language here.
What you'll do

In this codelab, you'll learn how to design and construct an app using the Architecture Components Room, ViewModel, and LiveData, and build an app that:

    Implements our recommended architecture using the Android Architecture Components.
    Works with a database to get and save the data, and pre-populates the database with some sample words.
    Displays all the words in a RecyclerView in the MainActivity class.
    Opens a second activity when the user taps the + button. When the user enters a word, that word is added to the database and displayed in the RecyclerView list.

The app is no-frills, but sufficiently complex that you can use it as a template to build upon. Here's a preview:


Using the Architecture Components

There are a lot of steps to using the Architecture Components and implementing the recommended architecture. The most important thing is to create a mental model of what is going on, understanding how the pieces fit together, and how the data flows. As you work through this codelab, don't just copy and paste the code, but try to start building that inner understanding.

What are the recommended Architecture Components?

Here is a short introduction to the Architecture Components and how they work together. Note that this codelab focuses on a subset of the components, namely LiveData, ViewModel and Room. Each component is explained in detail as you use it in your app.

This diagram shows a basic form of the architecture:

https://developer.android.com/codelabs/android-room-with-a-view-kotlin#1

Entity: Annotated class that describes a database table when working with Room.

SQLite database: On device storage. The Room persistence library creates and maintains this database for you.

DAO: Data access object. A mapping of SQL queries to functions. When you use a DAO, you call the methods, and Room takes care of the rest.

Room database: Simplifies database work and serves as an access point to the underlying SQLite database (hides SQLiteOpenHelper). The Room database uses the DAO to issue queries to the SQLite database.

Repository: A class that you create that is primarily used to manage multiple data sources.

ViewModel: Acts as a communication center between the Repository (data) and the UI. The UI no longer needs to worry about the origin of the data. ViewModel instances survive Activity/Fragment recreation.

LiveData: A data holder class that can be observed. Always holds/caches the latest version of data, and notifies its observers when data has changed. LiveData is lifecycle aware. UI components just observe relevant data and don't stop or resume observation. LiveData automatically manages all of this since it's aware of the relevant lifecycle status changes while observing.

Looking for more? Check out the full Guide to App Architecture.
RoomWordSample architecture overview

The following diagram shows all the pieces of the app. Each of the enclosing boxes (except for the SQLite database) represents a class that you will create.

https://developer.android.com/codelabs/android-room-with-a-view-kotlin#1
