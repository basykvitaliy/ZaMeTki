package space.basyk.zametki.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import space.basyk.zametki.models.PlanOfFoodModel

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFood(planOfFoodModel: PlanOfFoodModel)

    @Delete
    suspend fun deleteFood(planOfFoodModel: PlanOfFoodModel)

    @Query("SELECT * from plan_of_food_table")
    fun getAllFood(): LiveData<List<PlanOfFoodModel>>

}