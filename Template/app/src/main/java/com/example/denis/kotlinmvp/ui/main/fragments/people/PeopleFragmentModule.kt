package com.example.denis.kotlinmvp.ui.main.fragments.people

import com.example.denis.kotlinmvp.ui.main.fragments.people.interactor.PeopleInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.interactor.PeopleMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.presenter.PeopleMVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.presenter.PeoplePresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.view.PeopleMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by denis on 30/01/2018.
 */
@Module
class PeopleFragmentModule {
    @Provides
    internal fun providePeopleInteractor(interactor: PeopleInteractor): PeopleMVPInteractor = interactor

    @Provides
    internal fun providePeoplePresenter(presenter: PeoplePresenter<PeopleMVPView, PeopleMVPInteractor>)
            : PeopleMVPPresenter<PeopleMVPView, PeopleMVPInteractor> = presenter
}