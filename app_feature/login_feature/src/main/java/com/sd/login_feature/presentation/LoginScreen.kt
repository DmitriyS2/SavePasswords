package com.sd.login_feature.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sd.login_feature.presentation.LoginContract.Event
import com.sd.login_feature.presentation.LoginContract.State
import com.sd.util.ui.SavePasswordsTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun LoginScreen(
    state: State,
    onEvent: (Event) -> Unit,
    padding: PaddingValues
) {

    val focusManager = LocalFocusManager.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )
            {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Менеджер",
                    textAlign = TextAlign.Center,
                    fontSize = 48.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "паролей",
                    textAlign = TextAlign.Center,
                    fontSize = 48.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 104.dp),
                    value = state.loginText,
                    onValueChange = { onEvent.invoke(Event.ChangeTextLogin(it)) },
                    label = { Text(text = "Логин") },
                    singleLine = true,
                    isError = state.loginError,
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                    value = state.passwordText,
                    onValueChange = { onEvent.invoke(Event.ChangeTextPassword(it)) },
                    label = { Text(text = "Пароль") },
                    singleLine = true,
                    isError = state.passwordError,
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp, start = 16.dp, end = 16.dp),
                    onClick = {
                        focusManager.clearFocus()
                        onEvent.invoke(Event.OnClickEntry)
                    }) {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = "Войти",
                        fontSize = 20.sp
                    )
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 24.dp, end = 24.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = "Зарегистрироваться",
                        fontSize = 18.sp
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    SavePasswordsTheme {
        LoginScreen(
            state = State(),
            onEvent = {},
            padding = PaddingValues(0.dp)
        )
    }
}