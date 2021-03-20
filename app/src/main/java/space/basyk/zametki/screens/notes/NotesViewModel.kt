package space.basyk.zametki.screens.notes

import androidx.lifecycle.viewModelScope
import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.data.repository.DeleteRepository
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.utils.DeleteUseCase
import space.basyk.zametki.utils.NOTE_REPOSITORY

class NotesViewModel: EmptyViewModel() {
    val allNotes = NOTE_REPOSITORY.allNotes

    var repository = DeleteRepository(DeleteUseCase(viewModelScope))
    fun deleteNote(noteModel: NoteModel){
        repository.deleteNote(noteModel)
    }
}