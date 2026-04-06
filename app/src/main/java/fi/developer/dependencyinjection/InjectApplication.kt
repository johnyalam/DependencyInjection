package fi.developer.dependencyinjection

import android.app.Application
import fi.developer.dependencyinjection.di.dataModule
import fi.developer.dependencyinjection.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class InjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@InjectApplication)
            modules(dataModule, presentationModule)
        }
    }
}