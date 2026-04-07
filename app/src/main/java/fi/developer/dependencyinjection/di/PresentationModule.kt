package fi.developer.dependencyinjection.di

import fi.developer.dependencyinjection.ui.theme.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { UserViewModel(get()) }
}