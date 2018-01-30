package com.example.denis.kotlinmvp.ui.main.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.view.GalleryFragment
import com.example.denis.kotlinmvp.ui.main.fragments.permission.view.PermissionFragment
import com.example.denis.kotlinmvp.ui.main.interactor.MainMVPInteractor
import com.example.denis.kotlinmvp.ui.main.view.MainMVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 28/01/2018.
 */
class MainPresenter<V : MainMVPView, I : MainMVPInteractor>
    @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

    override fun onDrawerOptionGallery() {
        interactor?.let {
            when(it.isPermissionDataGranted()) {
                true -> getView()?.updateFrameLayout(GalleryFragment.newInstance())
                else -> getView()?.updateFrameLayout(PermissionFragment.newInstance())
            }
        }
    }
}