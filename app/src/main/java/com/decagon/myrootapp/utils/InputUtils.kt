package com.decagon.myrootapp.utils

class InputUtils {

    companion object{
        private val emailPattern = ("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").toRegex()
        private val phonePattern = """[0-9]+""".toRegex()
        fun validateEmail(email:String): Boolean{
            return email.trim().matches(emailPattern)
        }
    }
}