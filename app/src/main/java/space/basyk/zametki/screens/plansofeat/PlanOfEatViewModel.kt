package space.basyk.zametki.screens.plansofeat

import androidx.lifecycle.viewModelScope
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.data.repository.DeleteRepository
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.utils.DeleteUseCase
import space.basyk.zametki.utils.FOOD_REPOSITORY

class PlanOfEatViewModel: EmptyViewModel() {
    val allFood = FOOD_REPOSITORY.allFoods

    val repository = DeleteRepository(DeleteUseCase(viewModelScope))
    fun deleteFoods(planOfFoodModel: PlanOfFoodModel){
        repository.deleteFood(planOfFoodModel)
    }
}