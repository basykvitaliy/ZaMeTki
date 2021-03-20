package space.basyk.zametki.screens.shops

import androidx.lifecycle.viewModelScope
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.data.repository.DeleteRepository
import space.basyk.zametki.models.ShopModel
import space.basyk.zametki.utils.DeleteUseCase
import space.basyk.zametki.utils.SHOP_REPOSITORY

class ShopsViewModel:  EmptyViewModel() {
    val allShops = SHOP_REPOSITORY.allShops

    var repository = DeleteRepository(DeleteUseCase(viewModelScope))
    fun deleteShop(shopModel: ShopModel){
        repository.deleteShop(shopModel)
    }
}