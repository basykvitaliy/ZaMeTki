package space.basyk.zametki.screens.purpose

import androidx.lifecycle.viewModelScope
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.data.repository.DeleteRepository
import space.basyk.zametki.models.PurposeModel
import space.basyk.zametki.utils.DeleteUseCase
import space.basyk.zametki.utils.PURPOSE_REPOSITORY

class PurposeViewModel: EmptyViewModel() {
    val allPurpose = PURPOSE_REPOSITORY.allPurpose

    val repository = DeleteRepository(DeleteUseCase(viewModelScope))
    fun deletePurposes(purposeModel: PurposeModel){
        repository.deletePurpose(purposeModel)
    }
}