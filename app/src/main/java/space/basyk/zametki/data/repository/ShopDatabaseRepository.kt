package space.basyk.zametki.data.repository

import androidx.lifecycle.LiveData
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.models.ShopModel

interface ShopDatabaseRepository {

    val allShops: LiveData<List<ShopModel>>
    suspend fun insertShop(shopModel: ShopModel, onSuccess:() -> Unit)
    suspend fun deleteShop(shopModel: ShopModel, onSuccess:() -> Unit)

}