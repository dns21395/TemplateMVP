package com.example.denis.databaseroom.ui.gallery.photos

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.utils.AppIconRequestHandler
import com.example.denis.databaseroom.utils.GlideApp
import com.example.denis.databaseroom.utils.ImageRequestHandler
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.item_photo.view.*
import com.example.denis.databaseroom.R.id.toolbar
import android.graphics.drawable.BitmapDrawable
import android.R.attr.bitmap
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.squareup.picasso.Callback
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by denis on 19/12/2017.
 */
class PhotosAdapter(val glide: RequestManager, val context: Context) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {
    var photos = ArrayList<ImageGallery>()

    var picasso: Picasso? = null

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager


    private val TAG = "PhotosAdapter"

    init {
        val builder = Picasso.Builder(context)
        builder.addRequestHandler(ImageRequestHandler(context))
        picasso = builder.build()


    }

    fun setRecyclerLayoutManager(recyclerView: RecyclerView, layoutManager: LinearLayoutManager) {
        this.recyclerView = recyclerView
        this.layoutManager = layoutManager

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d(TAG, "onScrolledstatechanged = $newState")
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

            }
        })
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.image.setImageBitmap(null)
        holder.onBind(photos[position])
    }

    fun insertItems(array: ArrayList<ImageGallery>) {
        photos = array
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)

        val width = parent.width / 3

        val lp = RecyclerView.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        view.layoutParams = lp

        return PhotoViewHolder(view)

    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val target = BitmapLoaded(image)

        init {
            image.tag = target
        }

        fun onBind(imagePath: ImageGallery) = with(itemView) {
            picasso!!.load(imagePath.getUri())
                    .placeholder(R.drawable.placeholder)
                    .fit()
                    .centerCrop()
                    .into(image)




        }
    }
}