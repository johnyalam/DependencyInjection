package fi.developer.dependencyinjection.domain.repository

import fi.developer.dependencyinjection.domain.model.User

class UserRepositoryImpl : UserRepository {
    override fun getUser(): User {
        return User("Johny Alam", "johny@gmail.com")
    }

    override fun getAllUser(): List<User> {
        val userList = ArrayList<User>()
        for (i in 1..4) {
            userList.add(User("Johny Alam $i", "johny$i@gmail.com"))
        }
        return userList
    }
}