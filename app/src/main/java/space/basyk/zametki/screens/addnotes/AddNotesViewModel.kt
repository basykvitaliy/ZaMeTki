package space.basyk.zametki.screens.addnotes

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.utils.NOTE_REPOSITORY

class AddNotesViewModel: EmptyViewModel() {
    fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit) =
            viewModelScope.launch (Dispatchers.IO){
                NOTE_REPOSITORY.insertNote(noteModel){
                    onSuccess()
                }
            }
}