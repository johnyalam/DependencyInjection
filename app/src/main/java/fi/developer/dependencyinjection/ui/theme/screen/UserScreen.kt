package fi.developer.dependencyinjection.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.developer.dependencyinjection.ui.theme.components.UserAddContent
import fi.developer.dependencyinjection.ui.theme.components.UserContent
import fi.developer.dependencyinjection.ui.theme.components.UsersContent
import fi.developer.dependencyinjection.ui.theme.viewmodel.UserUiState
import fi.developer.dependencyinjection.ui.theme.viewmodel.UserViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = koinViewModel()) {
    val userState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxWidth()) {
        UserAddContent(
            onLoadSingleUser = {
                viewModel.getSingleUser()
            },
            onLoadMultipleUser = {
                viewModel.getMultipleUser()
            }
        )

        when(val state = userState) {
            is UserUiState.Loading -> {
                CircularProgressIndicator()
            }
            is UserUiState.Error -> {
                Text(text = "User Not Found!!!")
            }
            is UserUiState.SuccessSingle -> {
                UserContent(state.user)
            }
            is UserUiState.SuccessList -> {
                UsersContent(state.users)
            }
            is UserUiState.Idle -> {
            }
            else -> {}
        }
    }

}