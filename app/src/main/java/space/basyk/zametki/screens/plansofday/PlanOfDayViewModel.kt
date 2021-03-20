package space.basyk.zametki.screens.plansofday

import space.basyk.zametki.EmptyViewModel
import space.basyk.zametki.utils.DAY_REPOSITORY

class PlanOfDayViewModel: EmptyViewModel() {
    val allDay = DAY_REPOSITORY.allDays
}