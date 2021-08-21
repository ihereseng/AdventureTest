package com.example.adventuredemo

import android.app.Application
import com.example.adventuredemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AdventureApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AdventureApplication)
            modules(appModule)
        }
    }
}