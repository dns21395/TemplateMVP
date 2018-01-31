package com.example.denis.kotlinmvp.ui.main.fragments.people.view

import android.support.v4.app.DialogFragment
import com.example.denis.kotlinmvp.ui.base.view.MVPView

/**
 * Created by denis on 30/01/2018.
 */
interface PeopleMVPView : MVPView {
    fun showDialog(dialog: DialogFragment, tag: String)
}