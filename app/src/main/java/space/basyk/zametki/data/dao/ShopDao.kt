package space.basyk.zametki.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import space.basyk.zametki.models.ShopModel

@Dao
interface ShopDao {
    //Shop
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertShop(shopModel: ShopModel)

    @Delete
    suspend fun deleteShop(shopModel: ShopModel)

    @Query("SELECT * from shop_table")
    fun getAllShops(): LiveData<List<ShopModel>>
}