package ab.android.photoapp.ui.photos

import ab.android.photoapp.data.Photo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface PhotosView: MvpView {

    @AddToEndSingle
    fun addPhotos(photos: ArrayList<Photo>)
}