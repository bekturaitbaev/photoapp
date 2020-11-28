package ab.android.photoapp.ui.photos

import ab.android.photoapp.R
import ab.android.photoapp.data.Photo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_item.view.*


class PhotosAdapter(var photos: ArrayList<Photo?>) : RecyclerView.Adapter<PhotosAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return if (viewType == VIEW_TYPE_DATA){
            val v = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
            DataViewHolder(v)
        } else {
            val v = LayoutInflater.from(parent.context).inflate(
                R.layout.progress_item,
                parent,
                false
            )
            ProgressViewHolder(v)
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        if (holder is DataViewHolder) {
            holder.bindItems(photos[position]!!)
        } else {

        }
    }

    fun setNewPhotos(photos: ArrayList<Photo?>){
        this.photos = photos
        notifyDataSetChanged()
    }

    fun addNewPhotos(photos: ArrayList<Photo>){
        this.photos.addAll(photos)
        notifyDataSetChanged()
    }

    fun addNullData(){
        photos.add(null)
        notifyDataSetChanged()
    }

    fun  removeNullData(){
        photos.remove(null)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (photos[position] != null)
            VIEW_TYPE_DATA
        else
            VIEW_TYPE_LOADING
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    internal class DataViewHolder(itemView: View) :
        CustomViewHolder(itemView) {

        fun bindItems(item: Photo){
            itemView.photo_item_author.text = item.author
            Picasso.get().load(item.url).into(itemView.photo_item_img)
        }
    }

    internal class ProgressViewHolder(itemView: View) :
        CustomViewHolder(itemView)

    open class CustomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    companion object {
        const val VIEW_TYPE_DATA = 1
        const val VIEW_TYPE_LOADING = 2
    }
}