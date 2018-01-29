package com.example.denis.kotlinmvp.ui.main.application

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.example.denis.kotlinmvp.model.ApplicationInfoManager
import com.example.denis.kotlinmvp.ui.main.application.view.ApplicationAdapter
import com.example.denis.kotlinmvp.ui.main.application.interactor.ApplicationInteractor
import com.example.denis.kotlinmvp.ui.main.application.interactor.ApplicationMVPInteractor
import com.example.denis.kotlinmvp.ui.main.application.presenter.ApplicationMVPPresenter
import com.example.denis.kotlinmvp.ui.main.application.presenter.ApplicationPresenter
import com.example.denis.kotlinmvp.ui.main.application.view.ApplicationMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by denis on 28/01/2018.
 */
@Module
class ApplicationFragmentModule {
    @Provides
    internal fun provideApplicationInteractor(interactor: ApplicationInteractor): ApplicationMVPInteractor = interactor


    @Provides
    internal fun provideApplicationAdapter(context: Context): ApplicationAdapter = ApplicationAdapter(context)

    @Provides
    internal fun provideApplicationPresenter(presenter: ApplicationPresenter<ApplicationMVPView, ApplicationMVPInteractor>)
        : ApplicationMVPPresenter<ApplicationMVPView, ApplicationMVPInteractor> = presenter

    @Provides
    internal fun provideApplicationInfoManager(context: Context): ApplicationInfoManager = ApplicationInfoManager(context)

    @Provides
    internal fun provideLinearLayoutManager(context: Context): LinearLayoutManager = LinearLayoutManager(context)
}