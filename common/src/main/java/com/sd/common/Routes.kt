package com.sd.common

sealed class Routes(val route: String) {
    data object Login : Routes("loginScreen")
    data object Registration : Routes("registrationScreen")
    data object Main : Routes("mainScreen")
    data object NewItem : Routes("newItemScreen")
}