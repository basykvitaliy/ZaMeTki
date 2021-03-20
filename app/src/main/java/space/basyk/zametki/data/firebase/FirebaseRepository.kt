package space.basyk.zametki.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import space.basyk.zametki.utils.*

class FirebaseRepository {

    init {
        AUTH = FirebaseAuth.getInstance()
    }

    fun signIn(onSuccess:() -> Unit, onFail:(String) -> Unit){
        AUTH.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFail(it.message.toString()) }

    }

    fun createUser(onSuccess:() -> Unit, onFail:(String) -> Unit){
        AUTH.createUserWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFail(it.message.toString())  }
//        CURRENT_ID = AUTH.currentUser?.uid.toString()
//        REF_DATABASE = FirebaseDatabase.getInstance().reference.child(CURRENT_ID)
    }

}