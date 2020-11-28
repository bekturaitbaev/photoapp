package ab.android.photoapp.ui.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ab.android.photoapp.data.Photo
import ab.android.photoapp.databinding.FragmentPhotosBinding
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import javax.inject.Inject
import javax.inject.Provider

class PhotosFragment : MvpAppCompatFragment(), PhotosView {

    private lateinit var binding: FragmentPhotosBinding
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)

        initPhotosAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    // initializing photos adapter
    private fun initPhotosAdapter(){
        val photos = arrayListOf<Photo?>()
        photosAdapter = PhotosAdapter(photos)
        val layoutManager = LinearLayoutManager(context)
        binding.photosRecyclerview.layoutManager = layoutManager
        binding.photosRecyclerview.adapter = photosAdapter
    }

    override fun addPhotos(photos: ArrayList<Photo>) {

    }
}