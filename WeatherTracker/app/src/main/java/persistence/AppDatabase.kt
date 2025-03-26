package persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import persistence.dao.ForecastDao
import persistence.entities.ForecastResponseEntity

@Database(entities = [ForecastResponseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private const val DATABASE_NAME = "app_database"

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context)
            }

            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}