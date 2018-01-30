package com.example.denis.kotlinmvp.ui.main.fragments.gallery.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.model.GalleryImage
import com.example.denis.kotlinmvp.util.ImageRequestHandler
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_picture.view.*

/**
 * Created by denis on 29/01/2018.
 */
class GalleryAdapter(val context: Context) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    private var array = ArrayList<GalleryImage>()

    private var picasso: Picasso

    init {
        val builder = Picasso.Builder(context)
        builder.addRequestHandler(ImageRequestHandler(context))
        picasso = builder.build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_picture, parent, false)

        val width = parent.width / 3

        val lp = RecyclerView.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        view.layoutParams = lp

        return GalleryViewHolder(view)
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: GalleryViewHolder?, position: Int) {
        holder?.onBind(array[position])
    }

    fun updateArray(array: ArrayList<GalleryImage>) {
        this.array = array
        notifyDataSetChanged()
    }

    inner class GalleryViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: GalleryImage) = with(itemView) {
            picasso.load(item.uri)
                    .placeholder(R.drawable.placeholder_gallery)
                    .fit()
                    .centerCrop()
                    .into(image)
        }
    }
}