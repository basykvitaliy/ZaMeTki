package space.basyk.zametki.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plan_of_food_table")
class PlanOfFoodModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val date: String = "",

    @ColumnInfo
    val zavtrakFood: String = "",

    @ColumnInfo
    val obedFood: String = "",

    @ColumnInfo
    val uzinFood: String = "",
)