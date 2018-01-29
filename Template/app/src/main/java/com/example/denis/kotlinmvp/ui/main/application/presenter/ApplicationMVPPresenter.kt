package com.example.denis.kotlinmvp.ui.main.application.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.application.interactor.ApplicationMVPInteractor
import com.example.denis.kotlinmvp.ui.main.application.view.ApplicationMVPView

/**
 * Created by denis on 28/01/2018.
 */
interface ApplicationMVPPresenter<V : ApplicationMVPView, I : ApplicationMVPInteractor>
    : MVPPresenter<V, I>{
}