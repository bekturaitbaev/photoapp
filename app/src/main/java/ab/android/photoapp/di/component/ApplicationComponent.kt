package ab.android.photoapp.di.component

import ab.android.photoapp.BaseApp
import dagger.Component
import ab.android.photoapp.di.module.ApplicationModule
import ab.android.photoapp.di.module.NetworkModule
import ab.android.photoapp.ui.photos.PhotosFragment
import ab.android.photoapp.ui.signin.SignInFragment
import javax.inject.Singleton

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class])
@Singleton
interface ApplicationComponent {

    // application
    fun inject(application: BaseApp)

    // fragments
    fun inject(photosFragment: PhotosFragment)
    fun inject(signInFragment: SignInFragment)

}