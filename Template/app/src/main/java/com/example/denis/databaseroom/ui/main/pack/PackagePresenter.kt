package com.example.denis.databaseroom.ui.main.pack

import android.content.Context
import android.util.Log
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.di.ActivityContext
import com.example.denis.databaseroom.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by denis on 14/12/2017.
 */
class PackagePresenter<V: PackageMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), PackageMvpPresenter<V> {

    private val TAG = "PackagePresenter"

    override fun getPackages() {
        compositeDisposable.add(
                dataManager.getAll()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            for(item in it) {
                                Log.d(TAG, "$it")
                            }
                            mvpView?.updateArrayList(it as ArrayList<MyDatabase>)
                        }
        )


    }


}