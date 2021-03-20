package space.basyk.zametki.data.modelrepository

import androidx.lifecycle.LiveData
import space.basyk.zametki.data.dao.NoteDao
import space.basyk.zametki.data.repository.NoteDatabaseRepository
import space.basyk.zametki.models.NoteModel

class NoteRoomRepository(private val noteDao: NoteDao): NoteDatabaseRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insertNote(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.deleteNote(noteModel)
        onSuccess()
    }
}