package space.basyk.zametki.screens.start

import android.app.Application
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.data.db.NotesRoomDatabase
import space.basyk.zametki.data.modelrepository.*
import space.basyk.zametki.utils.*
import space.basyk.zametki.utils.FOOD_REPOSITORY

class StartViewModel(application: Application): EmptyViewModel() {

    private val context = application

    fun initDatabase(onSuccess:() -> Unit){
        val daoNote = NotesRoomDatabase.getInstance(context).getNoteDao()
        NOTE_REPOSITORY = NoteRoomRepository(daoNote)

        val daoShop = NotesRoomDatabase.getInstance(context).getShopDao()
        SHOP_REPOSITORY = ShopRoomRepository(daoShop)

        val daoPurpose = NotesRoomDatabase.getInstance(context).getPurposeDao()
        PURPOSE_REPOSITORY = PurposeRoomRepository(daoPurpose)

        val daoFood = NotesRoomDatabase.getInstance(context).getFoodDao()
        FOOD_REPOSITORY = FoodRoomRepository(daoFood)

        val daoDay = NotesRoomDatabase.getInstance(context).getDayDao()
        DAY_REPOSITORY = DayRoomRepository(daoDay)
    }


}