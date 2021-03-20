package space.basyk.zametki.utils

import android.widget.Toast

fun showToast(mess: String){
    Toast.makeText(APP_ACTIVITY_MAIN, mess, Toast.LENGTH_SHORT).show()
}

fun showToastTwo(mess: String){
    Toast.makeText(APP_ACTIVITY_START, mess, Toast.LENGTH_SHORT).show()
}