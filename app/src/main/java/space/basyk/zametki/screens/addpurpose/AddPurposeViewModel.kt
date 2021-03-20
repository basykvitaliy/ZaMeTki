package space.basyk.zametki.screens.addpurpose

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.models.PurposeModel
import space.basyk.zametki.utils.PURPOSE_REPOSITORY

class AddPurposeViewModel:EmptyViewModel() {
    fun insertPurpose(purposeModel: PurposeModel, onSuccess:() -> Unit) =
            viewModelScope.launch(Dispatchers.IO) {
                PURPOSE_REPOSITORY.insertPurpose(purposeModel){
                    onSuccess()
                }
            }
}