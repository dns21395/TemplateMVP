package com.example.denis.kotlinmvp.ui.main.fragments.gallery.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.interactor.GalleryMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.view.GalleryMVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 29/01/2018.
 */
class GalleryPresenter<V: GalleryMVPView, I : GalleryMVPInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    GalleryMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getGalleryImages()
    }

    private fun getGalleryImages() {
        interactor?.let {
            compositeDisposable.add(
                    Observable.fromCallable {
                        it.getGalleryImages()
                    }.compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe {
                                getView()?.displayGalleryImages(it)
                            }
            )


        }
    }
}