package fi.developer.dependencyinjection.di

import fi.developer.dependencyinjection.domain.repository.UserRepository
import fi.developer.dependencyinjection.domain.repository.UserRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}