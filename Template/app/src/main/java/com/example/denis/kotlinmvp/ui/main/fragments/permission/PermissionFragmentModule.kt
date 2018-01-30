package com.example.denis.kotlinmvp.ui.main.fragments.permission

import com.example.denis.kotlinmvp.ui.main.fragments.permission.interactor.PermissionInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.permission.interactor.PermissionMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.permission.presenter.PermissionMVPPResenter
import com.example.denis.kotlinmvp.ui.main.fragments.permission.presenter.PermissionPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.permission.view.PermissionMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by denis on 30/01/2018.
 */
@Module
class PermissionFragmentModule {
    @Provides
    internal fun providePermissionInteractor(interactor: PermissionInteractor): PermissionMVPInteractor = interactor

    @Provides
    internal fun providePermissionPresenter(presenter: PermissionPresenter<PermissionMVPView, PermissionMVPInteractor>)
        : PermissionMVPPResenter<PermissionMVPView, PermissionMVPInteractor> = presenter
}