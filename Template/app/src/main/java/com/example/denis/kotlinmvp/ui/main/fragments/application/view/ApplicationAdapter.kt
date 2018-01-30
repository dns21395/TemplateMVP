package com.example.denis.kotlinmvp.ui.main.fragments.application.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.model.AppInfo
import com.example.denis.kotlinmvp.util.ImageRequestHandler
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_application.view.*

/**
 * Created by denis on 28/01/2018.
 */
class ApplicationAdapter(val context: Context) : RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder>() {

    private var array = ArrayList<AppInfo>()

    private var picasso: Picasso

    init {
        val builder = Picasso.Builder(context)
        builder.addRequestHandler(ImageRequestHandler(context))
        picasso = builder.build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationViewHolder =
            ApplicationViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_application, parent, false))

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: ApplicationViewHolder?, position: Int) {
        holder?.onBind(array[position])
    }

    internal fun updateData(array: ArrayList<AppInfo>) {
        this.array = array
        notifyDataSetChanged()
    }

    inner class ApplicationViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun onBind(app: AppInfo) = with(itemView) {
            appName.text = app.applicationName

            picasso.load(ImageRequestHandler.getUri(app.packageName))
                    .placeholder(R.drawable.placeholder_application)
                    .into(appIcon)
        }
    }
}