package com.example.denis.kotlinmvp.ui.main.fragments.people.person

import com.example.denis.kotlinmvp.ui.main.fragments.people.person.interactor.InsertPersonInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.interactor.InsertPersonMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.presenter.InsertPersonMVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.presenter.InsertPersonPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.view.InsertPersonMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by denis on 31/01/2018.
 */
@Module
class InsertPersonDialogModule {
    @Provides
    internal fun provideInsertPersonInteractor(interactor: InsertPersonInteractor): InsertPersonMVPInteractor = interactor

    @Provides
    internal fun provideInsertPersonPresenter(presenter: InsertPersonPresenter<InsertPersonMVPView, InsertPersonMVPInteractor>)
        : InsertPersonMVPPresenter<InsertPersonMVPView, InsertPersonMVPInteractor> = presenter
}