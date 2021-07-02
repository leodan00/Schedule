package com.development.hybrid.schedule

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.development.hybrid.schedule.app.SharedPreferencesObject.getPreferenceBoolean
import com.development.hybrid.schedule.app.SharedPreferencesObject.stateAuthentication
import com.development.hybrid.schedule.constants.Globals
import com.development.hybrid.schedule.constants.Globals.TOASTY_TYPE_SUCCESS
import com.development.hybrid.schedule.constants.Globals.TOASTY_TYPE_WARNING
import com.development.hybrid.schedule.databinding.ActivitySplashScreenBinding
import com.development.hybrid.schedule.functions.PropertyActivity
import com.development.hybrid.schedule.tools.FunctionsGlobals.toShowToastyInContext
import com.development.hybrid.schedule.tools.FunctionsGlobals.verifyConnection
import com.development.hybrid.schedule.views.main.MainActivity
import com.rbddevs.splashy.Splashy
import java.util.*

class SplashScreenActivity : AppCompatActivity(), PropertyActivity.SplashScreen {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var splashy: Splashy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSplashy()

        if (getPreferenceBoolean(this@SplashScreenActivity, stateAuthentication)){
            continueSignInOrMain(true)
        }else{
            continueSignInOrMain(false)
        }

    }

    override fun setSplashy() {
        splashy = Splashy(this@SplashScreenActivity)
            .setLogo(R.mipmap.ic_launcher_round)
            .setAnimation(Splashy.Animation.SLIDE_IN_TOP_BOTTOM)
            .setBackgroundResource(R.color.purple_700)
            .setProgressColor(R.color.white)
            .setTitleColor(R.color.white)
            .setSubTitleColor(R.color.white)
            .setTitle(getString(R.string.app_name).uppercase(Locale.getDefault()))
            .setSubTitle(R.string.splash_screen_subtitle)
            .setSubTitleItalic(true)
            .setFullScreen(true)
            .showProgress(true)
    }

    override fun continueSignInOrMain(authentication: Boolean) {
        if (authentication){
            splashy.setInfiniteDuration(true).show()
            if (verifyConnection(this@SplashScreenActivity)){
                toShowToastyInContext(this@SplashScreenActivity, TOASTY_TYPE_SUCCESS, getString(R.string.text_value_message_welcome, "Joe"))
            }else{
                Splashy.hide()
                toShowToastyInContext(this@SplashScreenActivity, TOASTY_TYPE_WARNING, getString(R.string.text_value_offline_access_warning))
            }
        }else{
            splashy.setDuration(3600).show()
        }

        /**
         * Splashy Completed
         */
        Splashy.onComplete(object: Splashy.OnComplete{
            override fun onComplete() {
                onIntentActivityMain()
            }
        })

    }

    override fun onIntentActivityLogin() {
        TODO("Not yet implemented")
    }

    override fun onIntentActivityMain() {
        val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    override fun catchMessageShow(message: String?) {
        val value = if (message.isNullOrEmpty()) getString(R.string.text_value_message_error_default) else message
        toShowToastyInContext(this@SplashScreenActivity, Globals.TOASTY_TYPE_ERROR, value)
    }
}