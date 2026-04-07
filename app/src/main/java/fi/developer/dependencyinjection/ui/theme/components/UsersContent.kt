package fi.developer.dependencyinjection.ui.theme.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import fi.developer.dependencyinjection.domain.model.User

@Composable
fun UsersContent(users: List<User>) {
    LazyColumn() {
        items(users) { user ->
            UserContent(user)
        }
    }
}