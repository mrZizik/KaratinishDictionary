package ru.abdulmadzhidov.karatadictionary.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.abdulmadzhidov.karatadictionary.data.db.dao.WordsDao
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal

@Database(
    version = 1,
    entities = [
        WordLocal::class
    ]
)
abstract class DictionaryDatabase: RoomDatabase() {
    companion object {
        @Volatile
        private var instance: DictionaryDatabase? = null

        fun get(context: Context): DictionaryDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): DictionaryDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                DictionaryDatabase::class.java,
                "app.db"
            )
                .fallbackToDestructiveMigrationFrom()
                .createFromAsset("kar_rus.sql")
                .build()
        }
    }

    abstract fun wordsDao(): WordsDao

}