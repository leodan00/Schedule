package com.development.hybrid.schedule.functions

import android.content.Context

interface PropertyGlobalsFunctions {

    fun verifyConnection(context: Context): Boolean
    fun isConnectedMobile(context: Context): Boolean
    fun isConnectedWifi(context: Context): Boolean
    fun toShowToastyInContext(context: Context, typeToasty: Int, message: String)

}