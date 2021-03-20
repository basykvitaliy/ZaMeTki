package space.basyk.zametki.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import space.basyk.zametki.models.NoteModel
import space.basyk.zametki.models.ShopModel

@Dao
interface NoteDao {

    //Note
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(noteModel: NoteModel)

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)

    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>



}