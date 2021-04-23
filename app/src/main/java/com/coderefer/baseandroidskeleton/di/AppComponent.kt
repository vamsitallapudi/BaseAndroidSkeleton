package com.coderefer.baseandroidskeleton.di

import android.content.Context
import com.coderefer.baseandroidskeleton.di.modules.StorageModule
import com.coderefer.baseandroidskeleton.ui.home.HomeActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : AppComponent
    }
    fun injectActivity(activity: HomeActivity)
}