package ninja.bryansills.conventionplugintest.kmp.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

@Composable
fun WhatComposable() {
    MaterialTheme {
        var time: Instant? by remember { mutableStateOf(null) }
        LaunchedEffect(Unit) {
            time = getTime()
        }

        Box(modifier = Modifier.padding(32.dp)) {
            Text("Hello it is ${if (time != null) time.toString() else "???"}")
        }
    }
}

suspend fun getTime(): Instant {
    delay(5000)
    return Clock.System.now()
}

fun getJavaTime(): java.time.Instant {
    return java.time.Instant.now()
}