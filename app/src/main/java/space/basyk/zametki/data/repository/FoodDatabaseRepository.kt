package space.basyk.zametki.data.repository

import androidx.lifecycle.LiveData
import space.basyk.zametki.models.PlanOfFoodModel

interface FoodDatabaseRepository {
    val allFoods: LiveData<List<PlanOfFoodModel>>
    suspend fun insertFood(planOfFoodModel: PlanOfFoodModel, onSuccess:() -> Unit)
    suspend fun deleteFood(planOfFoodModel: PlanOfFoodModel, onSuccess:() -> Unit)
}