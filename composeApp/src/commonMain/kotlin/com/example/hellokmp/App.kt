package com.example.hellokmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import hellokmp.composeapp.generated.resources.Res
import hellokmp.composeapp.generated.resources.compose_multiplatform
import hellokmp.composeapp.generated.resources.news_app

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column (
            Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary),
           horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(Res.drawable.news_app), null, modifier = Modifier.height(100.dp).width(100.dp))
            Text(text = "Hello World Compose!")
        }
    }
}