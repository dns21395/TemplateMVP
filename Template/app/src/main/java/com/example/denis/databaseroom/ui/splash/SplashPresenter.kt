package com.example.denis.databaseroom.ui.splash

import android.content.Context
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import android.content.pm.ResolveInfo
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.di.ActivityContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import android.content.pm.PackageManager
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.content.pm.ApplicationInfo
import android.icu.lang.UCharacter.GraphemeClusterBreak.V






/**
 * Created by denis on 13/12/2017.
 */
class SplashPresenter<V: SplashMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), SplashMvpPresenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

        if(!dataManager.getFirstRun()) {
            insertPackagesToDatabase()
        } else {
            mvpView.openMainActivity()
        }
    }

    override fun insertPackagesToDatabase() {
        Observable.fromCallable {
            val pm = context.packageManager
            val packages = pm.getInstalledApplications(PackageManager.GET_META_DATA)

            for(item in packages) {
                dataManager.insert(MyDatabase(0, item.packageName, item.packageName.length.toLong()))
            }
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    dataManager.setFirstRun(true)
                    mvpView?.openMainActivity()
                }
    }
}