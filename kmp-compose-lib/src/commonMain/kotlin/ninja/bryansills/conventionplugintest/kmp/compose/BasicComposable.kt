package ninja.bryansills.conventionplugintest.kmp.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WhatComposable() {
    MaterialTheme {
        Box(modifier = Modifier.padding(32.dp)) {
            Text("Hello from what")
        }
    }
}