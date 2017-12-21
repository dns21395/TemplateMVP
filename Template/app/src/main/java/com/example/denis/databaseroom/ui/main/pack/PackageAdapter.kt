package com.example.denis.databaseroom.ui.main.pack

import android.content.Context
import android.graphics.Bitmap
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.utils.AppIconRequestHandler
import com.example.denis.databaseroom.utils.pxToDp
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable



/**
 * Created by denis on 14/12/2017.
 */
class PackageAdapter(var context: Context)
    : RecyclerView.Adapter<PackageAdapter.PackageViewHolder>() {
    private var items = ArrayList<MyDatabase>()
    private var recyclerView: RecyclerView? = null
    private var picasso: Picasso? = null

    private val TAG = "PackageAdapter"

    init {
        val builder = Picasso.Builder(context)
        builder.addRequestHandler(AppIconRequestHandler(context))
        picasso = builder.build()
    }

    fun setRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        holder.clear()
        holder.text.text = items[position].applicationName
        holder.count.text = items[position].length.toString()
        holder.onBind(position)
    }



    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_package, parent, false)

        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        view.layoutParams = lp

        return PackageViewHolder(view)
    }

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
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val text = itemView.findViewById<TextView>(R.id.text)
        val count = itemView.findViewById<TextView>(R.id.count)

        var database: MyDatabase? = null

        val target = IconLoaded(icon)

        init {
            icon.tag = target
        }


        fun onBind(position: Int) {
            database = items[position]

            picasso!!.load(AppIconRequestHandler.getUri(database!!.pack))
                    .into(target)

        }

        fun clear() {
            icon.setImageBitmap(null)
            text.text = ""
            count.text = ""
        }
    }
}