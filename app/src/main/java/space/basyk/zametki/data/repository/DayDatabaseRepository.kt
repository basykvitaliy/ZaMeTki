package space.basyk.zametki.data.repository

import androidx.lifecycle.LiveData
import space.basyk.zametki.models.PlanOfDayModel
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.models.PurposeModel

interface DayDatabaseRepository {
    val allDays: LiveData<List<PlanOfDayModel>>
}