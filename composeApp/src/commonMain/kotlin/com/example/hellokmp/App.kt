package com.example.hellokmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import hellokmp.composeapp.generated.resources.Res
import hellokmp.composeapp.generated.resources.battery
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@Composable
fun App(
    batteryManager: BatteryManager,
    pref: DataStore<Preferences>
) {
    val counter by pref
        .data.map {
            val counterKey = intPreferencesKey("counter")
            it[counterKey] ?: 0
        }.collectAsState(0)

    val scope = rememberCoroutineScope()
    MaterialTheme {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(Res.string.battery) + "${batteryManager.getBatteryLevel()}")

            Text(
                text = counter.toString(),
                fontSize = 50.sp
            )

            Button(onClick = {
                scope.launch{
                    pref.edit {datastore ->
                        val counterKey = intPreferencesKey("counter")
                        datastore[counterKey] = counter + 1
                    }
                }
            }){
                Text("Save!")
            }
        }
    }
}