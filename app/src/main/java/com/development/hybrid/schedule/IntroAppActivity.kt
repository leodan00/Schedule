package com.development.hybrid.schedule

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.development.hybrid.schedule.functions.PropertyActivity
import com.development.hybrid.schedule.views.main.MainActivity
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class IntroAppActivity : AppIntro(), PropertyActivity.IntroApp {

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!
        addSlide(AppIntroFragment.newInstance(
            "Welcome!",
            "This is a demo of the AppIntro library, with a custom background on each slide!",
            imageDrawable = R.drawable.ic_launcher_foreground
        ))

        addSlide(AppIntroFragment.newInstance(
            "Clean App Intros",
            "This library offers developers the ability to add clean app intros at the start of their apps.",
            imageDrawable = R.drawable.ic_launcher_foreground
        ))

        addSlide(AppIntroFragment.newInstance(
            "Simple, yet Customizable",
            "The library offers a lot of customization, while keeping it simple for those that like simple.",
            imageDrawable = R.drawable.ic_launcher_foreground
        ))

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        onIntentActivityMain()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        onIntentActivityMain()
    }

    override fun onIntentActivityMain() {
        val intent = Intent(this@IntroAppActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}