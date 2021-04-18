package com.example.castparty2;

import android.app.Application
import com.example.castparty2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CastParty2Application : Application() {

    companion object {
        lateinit var instance: CastParty2Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@CastParty2Application)
            modules(appModule)
        }
    }
}