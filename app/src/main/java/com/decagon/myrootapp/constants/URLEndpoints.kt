package com.decagon.myrootapp.constants

interface URLEndpoints {
    companion object{
        const val USER_ENDPOINT = "user"
        const val USER_LOGIN_ENDPOINT = "user/login"
        const val VERIFICATION_ENDPOINT = "verify"
        const val FORGOT_PASSWORD_ENDPOINT = "forgot-password"
        const val RESET_PASSWORD_ENDPOINT = "reset-password"
        const val TREE_ENDPOINT = "tree"
        const val SINGLE_TREE_ENDPOINT = "tree/{id}"
        const val USER_TREE_ENDPOINT = "tree/{user}/tree"
        const val PAYMENT_ENDPOINT = "payment"
        const val PAYMENT_UPDATE_ENDPOINT = "payment/{txref}"
        const val PAYMENT_UPDATE_STATUS_ENDPOINT = "payment/{txref}/status"

    }
}