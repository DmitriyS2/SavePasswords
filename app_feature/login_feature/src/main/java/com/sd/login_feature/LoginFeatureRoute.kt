package com.sd.login_feature

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.sd.login_feature.presentation.LoginContract
import com.sd.login_feature.presentation.LoginScreen
import com.sd.login_feature.presentation.LoginViewModel
import com.sd.util.ui.showToast

@Composable
fun LoginFeatureRoute(innerPadding: PaddingValues) {

    val context = LocalContext.current
    val viewModel = hiltViewModel<LoginViewModel>()
    val state = viewModel.state.collectAsState()

    LoginScreen(
        state = state.value,
        onEvent = viewModel::handleEvent,
        padding = innerPadding
    )

    LaunchedEffect(Unit) {
        viewModel.effect.collect {
            when (it) {
                LoginContract.Effect.NavigateToMain -> TODO()
                LoginContract.Effect.NavigateToRegistration -> TODO()
                LoginContract.Effect.ShowToastNotUser -> showToast(context, "Пользователь не зарегистрирован")
                LoginContract.Effect.ShowToastWrongLoginPassword -> showToast(context, "Неверный логин/пароль")
            }
        }
    }
}