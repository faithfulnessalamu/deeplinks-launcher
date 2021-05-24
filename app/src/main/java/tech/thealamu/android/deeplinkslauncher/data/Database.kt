package tech.thealamu.android.deeplinkslauncher.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DeepLink::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deeplinksDao(): DeepLinkDao
}

private lateinit var INSTANCE: AppDatabase
fun getAppDatabase(context: Context): AppDatabase {
    if (::INSTANCE.isInitialized) {
        return INSTANCE
    }

    synchronized(AppDatabase::class.java) {
        INSTANCE = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "appDatabase"
        ).build()
    }
    return INSTANCE
}
