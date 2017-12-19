package com.example.denis.databaseroom.ui.gallery.empty

import android.content.Context
import android.provider.MediaStore
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.di.ApplicationContext
import com.example.denis.databaseroom.ui.base.BasePresenter
import com.example.denis.databaseroom.ui.base.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 19/12/2017.
 */
class EmptyPresenter<V: EmptyMvpView>
    @Inject constructor(@ApplicationContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), EmptyMvpPresenter<V> {


}