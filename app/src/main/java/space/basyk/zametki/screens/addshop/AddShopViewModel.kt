package space.basyk.zametki.screens.addshop

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.models.ShopModel
import space.basyk.zametki.utils.SHOP_REPOSITORY

class AddShopViewModel:EmptyViewModel() {
    fun insertShop(shopModel: ShopModel, onSuccess:() -> Unit) =
            viewModelScope.launch(Dispatchers.IO) {
                SHOP_REPOSITORY.insertShop(shopModel){
                    onSuccess()
                }
            }
}