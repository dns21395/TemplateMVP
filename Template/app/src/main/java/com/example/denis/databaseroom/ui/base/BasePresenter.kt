package com.example.denis.databaseroom.ui.base

import android.content.Context
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.di.ActivityContext
import com.example.denis.databaseroom.di.ApplicationContext
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 13/12/2017.
 */
open class BasePresenter<V: MvpView>
    @Inject constructor(@ActivityContext var context: Context,
                        var dataManager: DataManager,
                        var compositeDisposable: CompositeDisposable): MvpPresenter<V> {
    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        mvpView = null
    }

}