package com.coderefer.baseandroidskeleton

import android.app.Application
import com.coderefer.baseandroidskeleton.di.AppComponent
import com.coderefer.baseandroidskeleton.di.DaggerAppComponent

class BaseApp : Application() {
    val appComponent : AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
    override fun onCreate() {
        super.onCreate()
    }
}