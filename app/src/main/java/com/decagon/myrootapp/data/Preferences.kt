package com.decagon.myrootapp.data

import android.app.Activity
import android.content.Context

class Preferences {
    companion object{
        private const val PREF_NAME = "user"
        private const val USER_AUTH = "token"
        private const val USER_MAIL = "email"
        private const val USER_NAME = "name"
        private const val USER_ID = "id"
        private const val USER_PHONE = "phone"

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

        fun saveName(activity: Activity, name: String){
            val preference = activity.getPreferences(Context.MODE_PRIVATE)
            with (preference.edit()) {
                putString(USER_NAME, name)
                commit()
            }
        }

        fun getName(activity: Activity): String {
            val preferences = activity.getPreferences(Context.MODE_PRIVATE)
            return preferences.getString(USER_NAME, "").toString()
        }

        fun saveID(activity: Activity, id: String){
            val preference = activity.getPreferences(Context.MODE_PRIVATE)
            with (preference.edit()) {
                putString(USER_ID, id)
                commit()
            }
        }

        fun getID(activity: Activity):String{
            val preferences = activity.getPreferences(Context.MODE_PRIVATE)
            return preferences.getString(USER_ID, "").toString()
        }

        fun savePhone(activity: Activity, phone: String){
            val preference = activity.getPreferences(Context.MODE_PRIVATE)
            with (preference.edit()) {
                putString(USER_PHONE, phone)
                commit()
            }
        }

        fun getPhone(activity: Activity): String{
            val preferences = activity.getPreferences(Context.MODE_PRIVATE)
            return preferences.getString(USER_PHONE, "").toString()
        }
    }
}