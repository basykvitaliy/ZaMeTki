package space.basyk.zametki.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import space.basyk.zametki.models.PurposeModel

@Dao
interface PurposeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPurpose(purposeModel: PurposeModel)

    @Delete
    suspend fun deletePurpose(purposeModel: PurposeModel)

    @Query("SELECT * from purpose_table")
    fun getAllPurpose(): LiveData<List<PurposeModel>>

}