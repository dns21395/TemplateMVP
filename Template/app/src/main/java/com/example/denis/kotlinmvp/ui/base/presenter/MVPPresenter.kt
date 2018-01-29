package com.example.denis.kotlinmvp.ui.base.presenter

import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor
import com.example.denis.kotlinmvp.ui.base.view.MVPView

/**
 * Created by denis on 27/01/2018.
 */
interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}