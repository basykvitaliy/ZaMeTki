package space.basyk.zametki

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import space.basyk.zametki.di.koinModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(koinModule)
        }
    }
    companion object{
        internal lateinit var INSTANCE: App
        private set
    }
}