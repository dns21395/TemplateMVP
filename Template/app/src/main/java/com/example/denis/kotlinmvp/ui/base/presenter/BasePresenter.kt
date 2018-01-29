package com.example.denis.kotlinmvp.ui.base.presenter

import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor
import com.example.denis.kotlinmvp.ui.base.view.MVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by denis on 27/01/2018.
 */
abstract class BasePresenter<V: MVPView, I: MVPInteractor>
    internal constructor(protected var interactor: I?,
                         protected var schedulerProvider: SchedulerProvider,
                         protected var compositeDisposable: CompositeDisposable)
    : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }
}