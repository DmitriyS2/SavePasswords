package com.sd.login_feature.presentation

import androidx.lifecycle.viewModelScope
import com.sd.base_feature.MviViewModel
import com.sd.login_feature.domain.usecase.GetPasswordByLoginUseCase
import com.sd.login_feature.presentation.LoginContract.Effect
import com.sd.login_feature.presentation.LoginContract.Event
import com.sd.login_feature.presentation.LoginContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val getPasswordByLoginUseCase: GetPasswordByLoginUseCase,
) : MviViewModel<State, Event, Effect>() {

    override fun initialState() = State()

    override fun handleEvent(event: Event) {
        when (event) {
            Event.OnClickEntry -> navigateToMain()
            Event.OnClickRegistration -> TODO()
            is Event.ChangeTextLogin -> setTextLogin(event.text)
            is Event.ChangeTextPassword -> setTextPassword(event.text)
        }
    }

    private fun navigateToMain() {
        viewModelScope.launch {
            setState { it.copy(loginError = state.value.loginText.isEmpty(), passwordError = state.value.passwordText.isEmpty()) }
            if (state.value.loginText.isEmpty() || state.value.passwordText.isEmpty()) return@launch
            val password = getPasswordByLoginUseCase(state.value.loginText)
            when {
                password == null -> setEffect(Effect.ShowToastNotUser)
                password != state.value.passwordText -> setEffect(Effect.ShowToastWrongLoginPassword)
                password == state.value.passwordText -> setEffect(Effect.NavigateToMain)
            }
        }
    }

    private fun setTextLogin(text: String) {
        setState { it.copy(loginText = text) }
    }

    private fun setTextPassword(text: String) {
        setState { it.copy(passwordText = text) }
    }
}