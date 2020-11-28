package ab.android.photoapp.ui.photos

import ab.android.photoapp.api.ApiServiceInterface
import ab.android.photoapp.data.Photo
import ab.android.photoapp.utils.Constant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class PhotosPresenter
@Inject
constructor(var api: ApiServiceInterface): MvpPresenter<PhotosView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadPhotos(1, Constant.PHOTO_LIMIT)
    }

    fun loadPhotos(page: Int, limit: Int){
        api.getPhotos(page, limit).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: ArrayList<Photo> ->
                viewState.addPhotos(list)
            }, { error ->

            })
    }

}