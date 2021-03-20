package space.basyk.zametki.data.repository

import androidx.lifecycle.LiveData
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.models.ShopModel

interface NoteDatabaseRepository {

    //note model
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit)
    //note model

    //

}