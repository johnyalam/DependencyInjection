package fi.developer.dependencyinjection.domain.repository

import fi.developer.dependencyinjection.domain.model.User

interface  UserRepository {
    fun getUser() : User
    fun getAllUser() : List<User>
}