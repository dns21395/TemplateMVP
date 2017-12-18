package com.example.denis.databaseroom.ui.main.pack

import android.content.Context
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


        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                when(newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> picasso?.resumeTag(context)
                    else -> picasso?.pauseTag(context)
                }
            }
        })
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        holder.onBind(position)
    }



    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder =
            PackageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_package, parent, false))

    fun insertItems(array: ArrayList<MyDatabase>) {
        Log.d(TAG, "INSER")
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


        fun onBind(position: Int) {
            val pack = items[position]

            picasso?.load(AppIconRequestHandler.getUri(pack.pack))
                    ?.noFade()
                    ?.fit()
                    ?.tag(context)
                    ?.placeholder(R.drawable.emoticon_devil)
                    ?.into(icon)

            text.text = pack.applicationName
            count.text = "${pack.length}"


        }
    }
}