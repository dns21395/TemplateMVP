package com.example.denis.databaseroom.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.denis.databaseroom.di.component.ActivityComponent

/**
 * Created by denis on 13/12/2017.
 */
abstract class BaseFragment: Fragment(), MvpView {
    var activity: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity) {
            activity = context
        }
    }

    override fun onDetach() {
        activity = null
        super.onDetach()
    }

    protected abstract fun setUp(view: View?)

    fun getActivityComponent(): ActivityComponent? = activity?.activityComponent

}