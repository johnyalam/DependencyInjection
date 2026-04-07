package fi.developer.dependencyinjection.ui.theme.viewmodel


import androidx.lifecycle.ViewModel
import fi.developer.dependencyinjection.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UserUiState?>(UserUiState.Idle)
    val uiState: StateFlow<UserUiState?> = _uiState.asStateFlow()

    fun getSingleUser() {
        _uiState.value = UserUiState.Loading

        repository.getUser().let {
            _uiState.value = UserUiState.SuccessSingle(it)
        }
    }

    fun getMultipleUser() {
        _uiState.value = UserUiState.Loading

        repository.getAllUser().let {
            _uiState.value = UserUiState.SuccessList(it)
        }
    }
}