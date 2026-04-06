package fi.developer.dependencyinjection.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserAddContent(onLoadSingleUser: () -> Unit,
                   onLoadMultipleUser: ()-> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Button(
            onClick = {
                onLoadSingleUser()
            }
        ) {
            Text(text = "Load Single User")
        }
        Spacer(Modifier.height(10.dp))
        Button(onClick ={
            onLoadMultipleUser()
        }){
            Text(text = "Load Multiple User")
        }
    }
}