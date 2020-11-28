package ab.android.photoapp.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideActivity(): Activity = (context as Activity)

}