package space.basyk.zametki.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import space.basyk.zametki.data.dao.*
import space.basyk.zametki.models.*

@Database(entities = [
    NoteModel::class,
    ShopModel::class,
    PurposeModel::class,
    PlanOfDayModel::class,
    PlanOfFoodModel::class
                     ], version = 9)
abstract class NotesRoomDatabase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
    abstract fun getShopDao(): ShopDao
    abstract fun getPurposeDao(): PurposeDao
    abstract fun getFoodDao(): FoodDao
    abstract fun getDayDao(): DayDao

    companion object{
        @Volatile
        private var database: NotesRoomDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): NotesRoomDatabase{
            return if (database == null){
                database = Room.databaseBuilder(context, NotesRoomDatabase::class.java, "db").fallbackToDestructiveMigration ().build()
                database as NotesRoomDatabase
            }else{
                database as NotesRoomDatabase
            }
        }
    }
}