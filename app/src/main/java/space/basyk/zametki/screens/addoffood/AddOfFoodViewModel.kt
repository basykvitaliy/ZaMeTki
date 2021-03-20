package space.basyk.zametki.screens.addoffood

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.utils.FOOD_REPOSITORY

class AddOfFoodViewModel: EmptyViewModel() {
    fun insertFood(planOfFoodModel: PlanOfFoodModel, onSuccess:() -> Unit) =
            viewModelScope.launch (Dispatchers.IO){
                FOOD_REPOSITORY.insertFood(planOfFoodModel){
                    onSuccess()
                }
            }
}