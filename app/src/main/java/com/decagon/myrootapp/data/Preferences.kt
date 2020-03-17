package com.decagon.myrootapp.data

import android.app.Activity
import android.content.Context

class Preferences {
    companion object{
        private const val PREF_NAME = "user"
        private const val USER_AUTH = "token"
        private const val USER_MAIL = "email"

        fun saveAuthToken(activity: Activity, token: String){
            val preference = activity.getPreferences(Context.MODE_PRIVATE)
            with (preference.edit()) {
                putString(USER_AUTH, token)
                commit()
            }
        }

        fun getAuthToken(activity: Activity): String{
            val preferences = activity.getPreferences(Context.MODE_PRIVATE)
            return preferences.getString(USER_AUTH, "").toString()
        }

        fun setEmail(activity: Activity, email: String){
            val preference = activity.getPreferences(Context.MODE_PRIVATE)
            with (preference.edit()) {
                putString(USER_MAIL, email)
                commit()
            }
        }

        fun getEmail(activity: Activity): String{
            val preferences = activity.getPreferences(Context.MODE_PRIVATE)
            return preferences.getString(USER_MAIL, "").toString()
        }
    }
}