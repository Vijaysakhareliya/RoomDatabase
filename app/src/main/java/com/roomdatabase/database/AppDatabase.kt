package com.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.roomdatabase.UserModel

/**
 * @Database : Create database for application
 * -> entities = Where we have to add all the tables Dao class for initialize table in Database
 * -> Version = Manage version for insert new fields or any other operation on table.
 *              also for Migration database to one version to second version
 * -> exportSchema : export the database schema into a folder. Even though it is not mandatory, it is a good
 * practice to have version history of your schema in your codebase and you should commit the
 * schema files into your version control system (but don't ship them with your app!).
 */
@Database(
    entities = [UserModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}