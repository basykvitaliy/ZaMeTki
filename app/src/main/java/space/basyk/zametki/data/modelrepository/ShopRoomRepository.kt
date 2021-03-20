package space.basyk.zametki.data.modelrepository

import androidx.lifecycle.LiveData
import space.basyk.zametki.data.dao.NoteDao
import space.basyk.zametki.data.dao.ShopDao
import space.basyk.zametki.data.repository.NoteDatabaseRepository
import space.basyk.zametki.data.repository.ShopDatabaseRepository
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.models.ShopModel

class ShopRoomRepository(private val shopDao: ShopDao): ShopDatabaseRepository {
    override val allShops: LiveData<List<ShopModel>>
        get() = shopDao.getAllShops()

    override suspend fun insertShop(shopModel: ShopModel, onSuccess: () -> Unit) {
        shopDao.insertShop(shopModel)
        onSuccess()
    }

    override suspend fun deleteShop(shopModel: ShopModel, onSuccess: () -> Unit) {
        shopDao.deleteShop(shopModel)
        onSuccess()
    }

}