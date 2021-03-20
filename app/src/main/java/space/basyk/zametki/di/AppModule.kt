package space.basyk.zametki.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import space.basyk.zametki.screens.addnotes.AddNotesViewModel
import space.basyk.zametki.screens.addoffood.AddOfFoodViewModel
import space.basyk.zametki.screens.addpurpose.AddPurposeViewModel
import space.basyk.zametki.screens.addshop.AddShopViewModel
import space.basyk.zametki.screens.notes.NotesViewModel
import space.basyk.zametki.screens.plansofday.PlanOfDayViewModel
import space.basyk.zametki.screens.plansofeat.PlanOfEatViewModel
import space.basyk.zametki.screens.purpose.PurposeViewModel
import space.basyk.zametki.screens.registration.RegistrViewModel
import space.basyk.zametki.screens.shops.ShopsViewModel
import space.basyk.zametki.screens.signin.SignInViewModel
import space.basyk.zametki.screens.start.StartViewModel
import space.basyk.zametki.utils.DeleteUseCase

val useCaseModule = module {

}
val repositoryModule = module {  }
val viewModelModule = module {
    viewModel { SignInViewModel() }
    viewModel { RegistrViewModel() }
    viewModel { ShopsViewModel() }
    viewModel { AddShopViewModel() }
    viewModel { PurposeViewModel() }
    viewModel { AddPurposeViewModel() }
    viewModel { PlanOfDayViewModel() }
    viewModel { PlanOfEatViewModel() }
    viewModel { AddOfFoodViewModel() }
    viewModel { NotesViewModel() }
    viewModel { AddNotesViewModel() }
    viewModel { StartViewModel(get()) }
}

val koinModule = useCaseModule+repositoryModule+viewModelModule