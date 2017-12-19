package com.example.denis.databaseroom.ui.gallery

import android.content.Context
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.di.ActivityContext
import com.example.denis.databaseroom.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 19/12/2017.
 */
class GalleryPresenter<V : GalleryMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), GalleryMvpPresenter<V> {
}