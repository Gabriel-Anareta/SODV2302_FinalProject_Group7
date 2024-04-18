package com.example.proj_phase2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proj_phase2.data.dao.EventDao
import com.example.proj_phase2.data.dao.LoginDao
import com.example.proj_phase2.data.dao.VenueDao
import com.example.proj_phase2.data.entities.Activity
import com.example.proj_phase2.data.entities.Event
import com.example.proj_phase2.data.entities.Login
import com.example.proj_phase2.data.entities.Venue

@Database(
    entities = [ Event::class, Activity::class, Venue::class, Login::class ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao
    abstract fun loginDao(): LoginDao
    abstract fun venueDao(): VenueDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .build().also { Instance = it }
            }
        }
    }
}