package com.development.hybrid.schedule.app

import android.content.Context
import android.content.SharedPreferences
import com.development.hybrid.schedule.functions.PropertySharedPreferences

object SharedPreferencesObject: PropertySharedPreferences {

    private const val stringPreferences = "com.development.hybrid.schedule"
    const val stateAuthentication = "state.auth"

    override fun savePreferenceBoolean(context: Context, boolean: Boolean, key: String?) {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        preferences.edit().putBoolean(key, boolean).apply()
    }

    override fun savePreferenceString(context: Context, string: String?, key: String?) {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        preferences.edit().putString(key, string).apply()
    }

    override fun savePreferenceInt(context: Context, int: Int, key: String?) {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        preferences.edit().putInt(key, int).apply()
    }

    override fun savePreferenceFloat(context: Context, float: Float, key: String?) {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        preferences.edit().putFloat(key, float).apply()
    }

    override fun savePreferenceLong(context: Context, long: Long, key: String?) {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        preferences.edit().putLong(key, long).apply()
    }

    override fun getPreferenceBoolean(context: Context, key: String?): Boolean {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        return preferences.getBoolean(
            key,
            false
        ) //if you have never been seed, this key returns false
    }

    override fun getPreferenceInt(context: Context, key: String?): Int {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        return preferences.getInt(key, 0) //if you have never been seed, this key returns 0
    }

    override fun getPreferenceFloat(context: Context, key: String?): Float {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        return preferences.getFloat(key, 0f) //if you have never been seed, this key returns 0
    }

    override fun getPreferenceLong(context: Context, key: String?): Long {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        return preferences.getLong(key, 0) //if you have never been seed, this key returns 0
    }

    override fun getPreferenceString(context: Context, key: String?): String? {
        val preferences: SharedPreferences =
            context.getSharedPreferences(stringPreferences, Context.MODE_PRIVATE)
        return preferences.getString(
            key,
            ""
        ) //if you have never been seed, this key returns an empty string
    }

}