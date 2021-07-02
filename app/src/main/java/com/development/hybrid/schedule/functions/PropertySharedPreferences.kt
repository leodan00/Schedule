package com.development.hybrid.schedule.functions

import android.content.Context

interface PropertySharedPreferences {

    fun savePreferenceBoolean(context: Context, boolean: Boolean, key: String?)
    fun savePreferenceString(context: Context, string: String?, key: String?)
    fun savePreferenceInt(context: Context, int: Int, key: String?)
    fun savePreferenceFloat(context: Context, float: Float, key: String?)
    fun savePreferenceLong(context: Context, long: Long, key: String?)

    fun getPreferenceBoolean(context: Context, key: String?): Boolean
    fun getPreferenceInt(context: Context, key: String?): Int
    fun getPreferenceFloat(context: Context, key: String?): Float
    fun getPreferenceLong(context: Context, key: String?): Long
    fun getPreferenceString(context: Context, key: String?): String?

}