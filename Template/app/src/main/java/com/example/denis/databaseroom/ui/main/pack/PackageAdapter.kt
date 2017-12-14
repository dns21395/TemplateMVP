package com.example.denis.databaseroom.ui.main.pack

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.BitmapDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.utils.GlideApp
import com.example.denis.databaseroom.utils.getApplicationName
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_package.view.*


/**
 * Created by denis on 14/12/2017.
 */
class PackageAdapter(var context: Context): RecyclerView.Adapter<PackageAdapter.PackageViewHolder>() {
    private var items = ArrayList<MyDatabase>()
    var recyclerView: RecyclerView? = null
    
    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder =
            PackageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_package, parent, false))

    fun insertItems(array: ArrayList<MyDatabase>) {
        when(items.size) {
            0 -> {
                items = array
                notifyDataSetChanged()
            }
            else -> {
                for(item in array) {
                    if(!items.contains(item)) {
                        items.add(0, item)
                        notifyItemInserted(0)
                    }
                }
            }
        }
        recyclerView?.smoothScrollToPosition(0)
    }

    inner class PackageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(position: Int) = with(itemView) {
            Observable.fromCallable {
                try {
                    val pack = items[position]
                    context.packageManager.getApplicationIcon(pack.pack) as BitmapDrawable
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        val pack = items[position]
                        GlideApp
                                .with(itemView.context)
                                .load(it)
                                .placeholder(R.mipmap.ic_launcher)
                                .into(icon)
                        val applicationName = getApplicationName(context, pack.pack)
                        text.text = applicationName
                        count.text = "${pack.length}"
                    }
        }

    }
}