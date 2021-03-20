package space.basyk.zametki.data.repository

import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.models.PurposeModel
import space.basyk.zametki.models.ShopModel
import space.basyk.zametki.utils.DeleteUseCase

class DeleteRepository(private val deleteUseCase: DeleteUseCase) {
    fun deleteNote(noteModel: NoteModel){
        deleteUseCase.deleteNote(noteModel){}
    }

    fun deleteShop(shopModel: ShopModel){
        deleteUseCase.deleteShop(shopModel){}
    }

    fun deletePurpose(purposeModel: PurposeModel){
        deleteUseCase.deleteSPurpose(purposeModel){}
    }

    fun deleteFood(planOfFoodModel: PlanOfFoodModel){
        deleteUseCase.deleteFood(planOfFoodModel){}
    }
}