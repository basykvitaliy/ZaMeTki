package space.basyk.zametki.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import space.basyk.zametki.FirstActivity
import space.basyk.zametki.MainActivity
import space.basyk.zametki.data.firebase.FirebaseRepository
import space.basyk.zametki.data.repository.*

lateinit var APP_ACTIVITY_MAIN: MainActivity
lateinit var APP_ACTIVITY_START: FirstActivity
lateinit var NOTE_REPOSITORY: NoteDatabaseRepository
lateinit var SHOP_REPOSITORY: ShopDatabaseRepository
lateinit var PURPOSE_REPOSITORY: PurposeDatabaseRepository
lateinit var FOOD_REPOSITORY: FoodDatabaseRepository
lateinit var DAY_REPOSITORY: DayDatabaseRepository

lateinit var FIREBASE: FirebaseRepository
lateinit var AUTH: FirebaseAuth
lateinit var EMAIL:String
lateinit var PASSWORD:String
lateinit var CURRENT_ID:String
lateinit var REF_DATABASE: DatabaseReference