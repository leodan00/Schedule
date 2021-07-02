@file:Suppress("DEPRECATION")

package com.development.hybrid.schedule.tools

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.development.hybrid.schedule.constants.Globals.TOASTY_TYPE_ERROR
import com.development.hybrid.schedule.constants.Globals.TOASTY_TYPE_INFO
import com.development.hybrid.schedule.constants.Globals.TOASTY_TYPE_SUCCESS
import com.development.hybrid.schedule.constants.Globals.TOASTY_TYPE_WARNING
import com.development.hybrid.schedule.functions.PropertyGlobalsFunctions
import es.dmoral.toasty.Toasty

object FunctionsGlobals: PropertyGlobalsFunctions {


    override fun verifyConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isAvailable && activeNetwork.isConnected
    }

    override fun isConnectedMobile(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_MOBILE
    }

    override fun isConnectedWifi(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_WIFI
    }

    override fun toShowToastyInContext(context: Context, typeToasty: Int, message: String) {
        when(typeToasty){
            TOASTY_TYPE_ERROR -> {
                Toasty.error(context, message, Toasty.LENGTH_LONG, true).show()
            }
            TOASTY_TYPE_WARNING -> {
                Toasty.warning(context, message, Toasty.LENGTH_LONG, true).show()
            }
            TOASTY_TYPE_INFO -> {
                Toasty.info(context, message, Toasty.LENGTH_LONG, true).show()
            }
            TOASTY_TYPE_SUCCESS -> {
                Toasty.success(context, message, Toasty.LENGTH_LONG, true).show()
            }
            else -> {
                Toasty.normal(context, message, Toasty.LENGTH_LONG).show()
            }
        }
    }
}