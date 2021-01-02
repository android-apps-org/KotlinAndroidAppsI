package com.jdemaagd.guessit.common

import android.app.Application
import timber.log.Timber

class GuessItApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}