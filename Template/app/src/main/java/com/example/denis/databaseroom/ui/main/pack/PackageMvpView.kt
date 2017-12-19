package com.example.denis.databaseroom.ui.main.pack

import android.support.v4.app.Fragment
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.ui.base.MvpView

/**
 * Created by denis on 14/12/2017.
 */
interface PackageMvpView: MvpView {
    fun updateArrayList(array: ArrayList<MyDatabase>)

}