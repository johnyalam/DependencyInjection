package fi.developer.dependencyinjection.ui.theme.viewmodel

import fi.developer.dependencyinjection.domain.model.User

sealed class UserUiState {
    object Idle : UserUiState()
    object Loading : UserUiState()
    data class SuccessSingle(val user: User) : UserUiState()
    data class SuccessList(val users: List<User>) : UserUiState()
    data class Error(val message: String?) : UserUiState()
}