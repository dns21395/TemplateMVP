package com.example.denis.databaseroom.utils

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

/**
 * Created by denis on 21/12/2017.
 */
class PreloadingLinearLayoutManager : LinearLayoutManager {
    private var pages: Int = 1
    private var orientationHelper: OrientationHelper? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, pages: Int) : super(context) {
        this.pages = pages
    }
    constructor(context: Context?, orientation: Int, reverseLayout: Boolean) : super(context, orientation, reverseLayout)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun setOrientation(orientation: Int) {
        super.setOrientation(orientation)
        orientationHelper = null
    }

    fun setPages(pages: Int) {
        this.pages = pages
    }

    override fun getExtraLayoutSpace(state: RecyclerView.State?): Int {
        if(orientationHelper == null) {
            orientationHelper = OrientationHelper.createOrientationHelper(this, orientation)
        }
        return orientationHelper!!.totalSpace * pages
    }



}