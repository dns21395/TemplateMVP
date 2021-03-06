package com.example.denis.kotlinmvp.ui.main.fragments.people.presenter

import android.util.Log
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.interactor.PeopleMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.view.PeopleMVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PeoplePresenter<V: PeopleMVPView, I : PeopleMVPInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), PeopleMVPPresenter<V, I> {


    private val TAG = "PeoplePresenter"

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getPersons()
        getAgeName()
    }

    private fun getPersons() {
        interactor?.let {
            it.getPersons()
            .compose(schedulerProvider.ioToMainFlowableScheduler())
                    .subscribe {
                        getView()?.displayPeople(it as ArrayList<Person>)
                    }
        }
    }

    private fun getAgeName() {
        interactor?.let {
            compositeDisposable.addAll(
                    it.getPersonsAge()
                            .compose(schedulerProvider.ioToMainFlowableScheduler())
                            .subscribe {
                                Log.d(TAG, "AGE")
                                for(item in it) {
                                    Log.d(TAG, "$item")
                                }
                            },
                    it.getPersonsName()
                            .compose(schedulerProvider.ioToMainFlowableScheduler())
                            .subscribe {
                                Log.d(TAG, "NAME")
                                for(item in it) {
                                    Log.d(TAG, "$item")
                                }
                            },
                    it.getPersons()
                            .compose(schedulerProvider.ioToMainFlowableScheduler())
                            .subscribe {
                                Log.d(TAG, "PERSON")
                                for(item in it) {
                                    Log.d(TAG, "$item")
                                }
                            }
            )
        }
    }

    override fun removePerson(person: Person) {
        interactor?.let {
            compositeDisposable.add(
                    Observable.fromCallable {
                        it.removePerson(person)
                    }.compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe()
            )
        }
    }

}