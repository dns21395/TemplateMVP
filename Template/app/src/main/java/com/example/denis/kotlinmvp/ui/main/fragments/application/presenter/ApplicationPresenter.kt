package com.example.denis.kotlinmvp.ui.main.fragments.application.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.main.fragments.application.interactor.ApplicationMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.application.view.ApplicationMVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 28/01/2018.
 */
class ApplicationPresenter<V : ApplicationMVPView, I : ApplicationMVPInteractor>
    @Inject internal constructor(interactor: I,
                                 schedulerProvider: SchedulerProvider,
                                 disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        ApplicationMVPPresenter<V, I> {

    private val TAG = "ApplicationPresenter"

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getApplicationsArray()
    }

    private fun getApplicationsArray() = interactor?.let {
        compositeDisposable.add(Observable.fromCallable {
            it.getApplicationInfoArray()
        }.compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { applicationArray ->
                    getView()?.displayApplications(applicationArray)
                })
    }
}