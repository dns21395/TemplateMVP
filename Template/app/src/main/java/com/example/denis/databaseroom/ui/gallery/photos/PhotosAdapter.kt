package com.example.denis.databaseroom.ui.gallery.photos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.denis.databaseroom.R
import kotlinx.android.synthetic.main.item_photo.view.*

/**
 * Created by denis on 19/12/2017.
 */
class PhotosAdapter(val context: Context) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {
    var photos = ArrayList<String>()

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBind(photos[position])
    }

    fun insertItems(array: ArrayList<String>) {
        photos = array
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)

        val width = parent.width / 3
        view.minimumWidth = width

        return PhotoViewHolder(view)

    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(imagePath: String) = with(itemView) {
            Glide.with(context)
                    .load(imagePath)
                    .into(image)
        }
    }
}