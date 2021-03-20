package space.basyk.zametki.data.modelrepository

import androidx.lifecycle.LiveData
import space.basyk.zametki.data.dao.FoodDao
import space.basyk.zametki.data.repository.FoodDatabaseRepository
import space.basyk.zametki.models.PlanOfFoodModel

class FoodRoomRepository(private val foodDao: FoodDao): FoodDatabaseRepository {
    override val allFoods: LiveData<List<PlanOfFoodModel>>
        get() = foodDao.getAllFood()

    override suspend fun insertFood(planOfFoodModel: PlanOfFoodModel, onSuccess: () -> Unit) {
        foodDao.insertFood(planOfFoodModel)
        onSuccess()
    }

    override suspend fun deleteFood(planOfFoodModel: PlanOfFoodModel, onSuccess: () -> Unit) {
        foodDao.deleteFood(planOfFoodModel)
        onSuccess()
    }
}