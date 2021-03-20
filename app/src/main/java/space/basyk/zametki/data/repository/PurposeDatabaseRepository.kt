package space.basyk.zametki.data.repository

import androidx.lifecycle.LiveData
import space.basyk.zametki.models.PurposeModel

interface PurposeDatabaseRepository {
    val allPurpose: LiveData<List<PurposeModel>>
    suspend fun insertPurpose(purposeModel: PurposeModel, onSuccess:() -> Unit)
    suspend fun deletePurpose(purposeModel: PurposeModel, onSuccess:() -> Unit)
}