package com.example.denis.databaseroom.ui.gallery.photos

import android.content.Context
import android.provider.MediaStore
import android.util.Log
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.di.ActivityContext
import com.example.denis.databaseroom.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by denis on 19/12/2017.
 */
class PhotosPresenter<V: PhotosMvpView>
@Inject constructor(@ActivityContext context: Context,
                    dataManager: DataManager,
                    compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), PhotosMvpPresenter<V> {

    private val TAG = "PhotosPresenter"

    override fun getImages() {
        Log.d(TAG, "getImages")
        Observable.fromCallable {
            val images = ArrayList<String>()

            val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val projection = arrayOf(MediaStore.MediaColumns.DATA)

            val cursor = context.contentResolver.query(uri,
                    projection,
                    null,
                    null,
                    null)

            Log.d(TAG, "cursor size ; ${cursor.count}")
            cursor.moveToFirst()
            while(cursor.moveToNext()) {
                val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
                images.add(cursor.getString(columnIndex))
            }

            cursor.close()

            images
        }.subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe {
                    mvpView?.updateRecyclerView(it)
                }

    }
}