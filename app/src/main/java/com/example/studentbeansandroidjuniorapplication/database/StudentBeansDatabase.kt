package com.example.studentbeansandroidjuniorapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [DbPhoto::class],
    version = 1,
    exportSchema = false
)

abstract class StudentBeansDatabase : RoomDatabase() {
    abstract val studentBeansDatabaseDao: StudentBeansDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: StudentBeansDatabase? = null

        fun getDatabase(context: Context): StudentBeansDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentBeansDatabase::class.java,
                        "student_beans_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
