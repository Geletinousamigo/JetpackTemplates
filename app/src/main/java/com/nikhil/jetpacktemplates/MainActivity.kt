package com.nikhil.jetpacktemplates

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.WideButton
import com.nikhil.core.designsystem.AppTheme
import com.nikhil.core.designsystem.TvAppTheme
import androidx.tv.material3.Text as TvText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val isTelevision =
                context.packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)
            if (!isTelevision) {
                App()
            } else {
                TvApp()
            }
        }
    }
}

@Composable
fun App() {

    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Hello World", modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, device = "id:CCWGTV", showBackground = true)
@Composable
fun TvApp() {
    val focusRequester = remember { FocusRequester() }
    var text by remember { mutableStateOf("")}
    TvAppTheme {
        Row(modifier =Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(.6f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                TvText(
                    text = "Hello World",
                )
                Spacer(modifier = Modifier.height(8.dp))
                WideButton(
                    onClick = { focusRequester.requestFocus() }
                ) {
                    Text(text = "Click to move focus")
                }
            }
            Column {
                Spacer(modifier = Modifier.height(40.dp))
                OutlinedTextField(
                    modifier = Modifier.focusRequester(focusRequester),
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label =  {
                        Text(text = "Username")
                    }
                )
            }

        }
    }
}