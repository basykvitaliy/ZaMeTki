package space.basyk.zametki.data.modelrepository

import androidx.lifecycle.LiveData
import space.basyk.zametki.data.dao.PurposeDao
import space.basyk.zametki.data.repository.PurposeDatabaseRepository
import space.basyk.zametki.models.PurposeModel

class PurposeRoomRepository(private val purposeDao: PurposeDao): PurposeDatabaseRepository {
    override val allPurpose: LiveData<List<PurposeModel>>
        get() = purposeDao.getAllPurpose()

    override suspend fun insertPurpose(purposeModel: PurposeModel, onSuccess: () -> Unit) {
        purposeDao.insertPurpose(purposeModel)
        onSuccess()
    }

    override suspend fun deletePurpose(purposeModel: PurposeModel, onSuccess: () -> Unit) {
        purposeDao.deletePurpose(purposeModel)
        onSuccess()
    }
}