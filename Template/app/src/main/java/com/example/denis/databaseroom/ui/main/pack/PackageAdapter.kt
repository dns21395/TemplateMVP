package com.example.denis.databaseroom.ui.main.pack

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.BitmapDrawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.utils.GlideApp
import com.example.denis.databaseroom.utils.getApplicationName
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_package.view.*
import org.jetbrains.anko.doAsync


/**
 * Created by denis on 14/12/2017.
 */
class PackageAdapter(var context: Context)
    : RecyclerView.Adapter<PackageAdapter.PackageViewHolder>() {
    private var items = ArrayList<MyDatabase>()
    private var recyclerView: RecyclerView? = null
    private var layoutManager: LinearLayoutManager? = null

    private val TAG = "PackageAdapter"

    fun setRecyclerView(recyclerView: RecyclerView, layoutManager: LinearLayoutManager) {
        this.recyclerView = recyclerView
        this.layoutManager = layoutManager
//
//        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if(newState != 0) {
//                    Log.d(TAG, "newState = $newState")
//                    compositeDisposable.dispose()
//                } else {
//                    Log.d(TAG, "newState = 0")
//
//                    val first = layoutManager.findFirstVisibleItemPosition()
//                    val last = layoutManager.findLastVisibleItemPosition()
//
//                    notifyItemRangeChanged(first, last)
//                }
//            }
//        })
    }

    override fun onViewRecycled(holder: PackageViewHolder?) {
        if(holder != null) {
            holder.compositeDisposable.clear()
            holder.text.text = ""
            holder.count.text = ""
            holder.icon.setImageResource(android.R.color.transparent)
        }

        super.onViewRecycled(holder)
    }

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
        val compositeDisposable = CompositeDisposable()

        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val text = itemView.findViewById<TextView>(R.id.text)
        val count = itemView.findViewById<TextView>(R.id.count)

        fun onBind(position: Int) {
            loadImage(position)
        }

        fun loadImage(position: Int) = with(itemView) {
            compositeDisposable.add(Observable.fromCallable {
                try {
                    val pack = items[position]
                    context.packageManager.getApplicationIcon(pack.pack) as BitmapDrawable
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        GlideApp
                                .with(itemView.context)
                                .load(it)
                                .into(icon)

                        val pack = items[position]

                        text.text = pack.applicationName
                        count.text = "${pack.length}"

                    })
        }
    }
}