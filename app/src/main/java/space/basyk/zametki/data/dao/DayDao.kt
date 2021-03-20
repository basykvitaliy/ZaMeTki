package space.basyk.zametki.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import space.basyk.zametki.models.PlanOfDayModel
import space.basyk.zametki.models.PurposeModel

@Dao
interface DayDao {
    @Query("SELECT * from plan_of_day_table")
    fun getAllDay(): LiveData<List<PlanOfDayModel>>
}