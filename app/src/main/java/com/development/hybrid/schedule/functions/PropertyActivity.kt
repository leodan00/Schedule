package com.development.hybrid.schedule.functions

interface PropertyActivity {

    interface SplashScreen{
        fun setSplashy()
        fun continueSignInOrMain(authentication: Boolean)
        fun onIntentActivityLogin()
        fun onIntentActivityMain()
        fun catchMessageShow(message: String?)
    }

    interface IntroApp{
        fun onIntentActivityMain()
    }

}