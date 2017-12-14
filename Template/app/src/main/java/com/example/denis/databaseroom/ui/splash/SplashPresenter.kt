package com.example.denis.databaseroom.ui.splash

import android.content.Context
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.di.ActivityContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import android.content.pm.PackageManager
import android.util.Log


/**
 * Created by denis on 13/12/2017.
 */
class SplashPresenter<V: SplashMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), SplashMvpPresenter<V> {

    private val TAG = "SplashPresenter"

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

        if(!dataManager.getFirstRun()) {
            Log.d(TAG, "insertPackagesToDatabase")
            insertPackagesToDatabase()
        } else {
            Log.d(TAG, "opemMainActivity")
            mvpView.openMainActivity()
        }
    }

    override fun insertPackagesToDatabase() {
        Observable.fromCallable {
            val packageManager = context.packageManager

            for(item in packageManager.getInstalledApplications(PackageManager.GET_META_DATA)) {
                try {
                    if(null != packageManager.getLaunchIntentForPackage(item.packageName)) {
                        Log.d(TAG, item.packageName)
                        dataManager.insert(MyDatabase(0, item.packageName, item.packageName.length.toLong()))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    dataManager.setFirstRun(true)
                    mvpView?.openMainActivity()
                }
    }
}