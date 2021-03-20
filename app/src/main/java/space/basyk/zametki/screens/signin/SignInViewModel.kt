package space.basyk.zametki.screens.signin

import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.data.firebase.FirebaseRepository
import space.basyk.zametki.utils.FIREBASE
import space.basyk.zametki.utils.showToast
import space.basyk.zametki.utils.showToastTwo

class SignInViewModel: EmptyViewModel() {
    fun initSignIn(onSuccess:() -> Unit){
        FIREBASE = FirebaseRepository()
        FIREBASE.signIn(
            {onSuccess()},
            { showToastTwo("Введите правильный адресс или зарегистрируйтесь!") }
        )
    }
}