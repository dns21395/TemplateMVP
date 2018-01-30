package com.example.denis.kotlinmvp.ui.main.fragments.people.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.interactor.PeopleMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.view.PeopleMVPView

/**
 * Created by denis on 30/01/2018.
 */
interface PeopleMVPPresenter<V: PeopleMVPView, I : PeopleMVPInteractor> : MVPPresenter<V, I> {
}