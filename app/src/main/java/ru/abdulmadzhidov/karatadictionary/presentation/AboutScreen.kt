package ru.abdulmadzhidov.karatadictionary.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.abdulmadzhidov.karatadictionary.BuildConfig
import ru.abdulmadzhidov.karatadictionary.R

@Composable
fun AboutScreen(shareAppClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(128.dp),
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineSmall,
                text = "${stringResource(id = R.string.app_name)} v.${BuildConfig.VERSION_NAME}"
            )
            Spacer(modifier = Modifier.size(8.dp))
            Button(
                colors = ButtonDefaults.buttonColors()
                    .copy(containerColor = MaterialTheme.colorScheme.secondary),
                onClick = shareAppClick
            ) {
                Text(text = stringResource(id = R.string.share))
            }
        }
    }
}