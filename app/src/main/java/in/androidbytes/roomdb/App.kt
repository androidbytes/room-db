package `in`.androidbytes.roomdb

import `in`.androidbytes.roomdb.data.AppDatabase
import android.app.Application
import android.arch.persistence.room.Room

class App : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "room-db")
                .allowMainThreadQueries()
                .build()
    }
}