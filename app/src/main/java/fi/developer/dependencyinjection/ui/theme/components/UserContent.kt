package fi.developer.dependencyinjection.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fi.developer.dependencyinjection.domain.model.User

@Composable
fun UserContent(user: User) {
    Card (modifier = Modifier.padding(10.dp)){
        Column(modifier = Modifier.padding(10.dp).fillMaxWidth()){
            Text(text = user.name)
            Text(text = user.email)
        }
        Spacer(Modifier.height(10.dp))
    }
}