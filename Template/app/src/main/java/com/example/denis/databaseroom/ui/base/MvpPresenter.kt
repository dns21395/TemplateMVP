package com.example.denis.databaseroom.ui.base

/**
 * Created by denis on 13/12/2017.
 */
interface MvpPresenter<V: MvpView> {
    fun onAttach(mvpView: V)

    fun onDetach()
}