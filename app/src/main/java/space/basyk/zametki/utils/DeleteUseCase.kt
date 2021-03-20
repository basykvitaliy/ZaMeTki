package space.basyk.zametki.utils

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.Koin
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.models.PurposeModel
import space.basyk.zametki.models.ShopModel

class DeleteUseCase(private val viewModelScope: CoroutineScope) {
    fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit) =
            viewModelScope.launch (Dispatchers.IO){
                NOTE_REPOSITORY.deleteNote(noteModel){
                    onSuccess()
                }
            }

    fun deleteShop(shopModel: ShopModel, onSuccess:() -> Unit) =
            viewModelScope.launch (Dispatchers.IO){
                SHOP_REPOSITORY.deleteShop(shopModel){
                    onSuccess()
                }
            }
    fun deleteSPurpose(purposeModel: PurposeModel, onSuccess:() -> Unit) =
            viewModelScope.launch (Dispatchers.IO){
                PURPOSE_REPOSITORY.deletePurpose(purposeModel){
                    onSuccess()
                }
            }

    fun deleteFood(planOfFoodModel: PlanOfFoodModel, onSuccess:() -> Unit) =
            viewModelScope.launch (Dispatchers.IO){
                FOOD_REPOSITORY.deleteFood(planOfFoodModel){
                    onSuccess()
                }
            }
}