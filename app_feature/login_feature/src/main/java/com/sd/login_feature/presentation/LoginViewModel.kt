package com.sd.login_feature.presentation

import com.sd.base_feature.MviViewModel
import com.sd.login_feature.presentation.LoginContract.Effect
import com.sd.login_feature.presentation.LoginContract.Event
import com.sd.login_feature.presentation.LoginContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor() : MviViewModel<State, Event, Effect>() {

    override fun initialState() = State()

    override fun handleEvent(event: Event) {
        when (event) {
            Event.OnClickEntry -> TODO()
            Event.OnClickRegistration -> TODO()
            is Event.ChangeTextLogin -> setTextLogin(event.text)
            is Event.ChangeTextPassword -> setTextPassword(event.text)
        }
    }

    private fun setTextLogin(text: String) {
        setState { it.copy(loginText = text) }
    }

    private fun setTextPassword(text: String) {
        setState { it.copy(passwordText = text) }
    }
}