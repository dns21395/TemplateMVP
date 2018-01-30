package com.example.denis.kotlinmvp.ui.main.fragments.application.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.application.interactor.ApplicationMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.application.view.ApplicationMVPView

/**
 * Created by denis on 28/01/2018.
 */
interface ApplicationMVPPresenter<V : ApplicationMVPView, I : ApplicationMVPInteractor>
    : MVPPresenter<V, I>{
}