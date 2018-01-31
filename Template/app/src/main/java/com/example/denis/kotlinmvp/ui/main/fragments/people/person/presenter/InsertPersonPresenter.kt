package com.example.denis.kotlinmvp.ui.main.fragments.people.person.presenter

import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.interactor.InsertPersonMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.view.InsertPersonMVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 31/01/2018.
 */
class InsertPersonPresenter<V: InsertPersonMVPView, I : InsertPersonMVPInteractor>
    @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), InsertPersonMVPPresenter<V, I> {

    override fun onButtonAddClicked(name: String, age: Int?) {
        interactor?.let {
            when(name.isNotEmpty() && age != null) {
                true -> {
                    Observable.fromCallable {
                        it.insertPerson(Person(0, name, age!!))
                    }.compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe {
                                getView()?.showToast(R.string.person_added)
                                getView()?.closeDialog()
                            }
                }
                else -> {
                    getView()?.showToast(R.string.empty_fields)
                }
            }
        }
    }


}