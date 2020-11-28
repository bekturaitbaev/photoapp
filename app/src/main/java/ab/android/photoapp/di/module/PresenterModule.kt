package ab.android.photoapp.di.module

import ab.android.photoapp.api.ApiServiceInterface
import ab.android.photoapp.ui.photos.PhotosPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providePhotosPresenter(api: ApiServiceInterface) =
        PhotosPresenter(api)
}