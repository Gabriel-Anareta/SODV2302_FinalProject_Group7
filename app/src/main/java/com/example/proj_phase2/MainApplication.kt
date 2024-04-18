package com.example.proj_phase2

import android.app.Application
import com.example.proj_phase2.data.AppContainer
import com.example.proj_phase2.data.AppDataContainer

class MainApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}