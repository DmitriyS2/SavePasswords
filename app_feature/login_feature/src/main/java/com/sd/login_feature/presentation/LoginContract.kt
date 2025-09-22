package com.sd.login_feature.presentation

import com.sd.base_feature.MviEffect
import com.sd.base_feature.MviEvent
import com.sd.base_feature.MviState

internal object LoginContract {
    sealed interface Event : MviEvent {
        data class ChangeTextLogin(val text: String) : Event
        data class ChangeTextPassword(val text: String) : Event
        data object OnClickEntry : Event
        data object OnClickRegistration : Event
    }

    data class State(
        val loginText: String = "",
        val passwordText: String = "",
    ) : MviState

    sealed interface Effect : MviEffect {
        data object NavigateToMain : Effect
        data object NavigateToRegistration : Effect
    }
}