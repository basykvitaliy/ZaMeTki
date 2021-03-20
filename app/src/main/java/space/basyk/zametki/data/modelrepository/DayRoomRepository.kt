package space.basyk.zametki.data.modelrepository

import androidx.lifecycle.LiveData
import space.basyk.zametki.data.dao.DayDao
import space.basyk.zametki.data.repository.DayDatabaseRepository
import space.basyk.zametki.models.PlanOfDayModel
import space.basyk.zametki.models.PurposeModel

class DayRoomRepository(private val dayDao: DayDao): DayDatabaseRepository {
    override val allDays: LiveData<List<PlanOfDayModel>>
        get() = dayDao.getAllDay()
}