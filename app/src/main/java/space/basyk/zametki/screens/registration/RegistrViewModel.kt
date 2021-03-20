package space.basyk.zametki.screens.registration

import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.data.firebase.FirebaseRepository
import space.basyk.zametki.utils.FIREBASE
import space.basyk.zametki.utils.showToastTwo

class RegistrViewModel:EmptyViewModel() {
    fun createUser(onSuccess:() -> Unit){
        FIREBASE = FirebaseRepository()
        FIREBASE.createUser(
            {onSuccess()},
            { showToastTwo("Такой пользователь уже зарегистрирован!") })
    }
}