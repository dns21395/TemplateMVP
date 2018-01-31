package com.example.denis.kotlinmvp.ui.main.fragments.people.person.view

import android.app.Dialog
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.ui.base.view.BaseDialog
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.interactor.InsertPersonMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.presenter.InsertPersonMVPPresenter
import javax.inject.Inject

/**
 * Created by denis on 31/01/2018.
 */
class InsertPersonDialog : BaseDialog(), InsertPersonMVPView {
    companion object {
        val TAG = "InsertPersonDialog"
        fun newInstance(): InsertPersonDialog = InsertPersonDialog()
    }

    @Inject lateinit var presenter: InsertPersonMVPPresenter<InsertPersonMVPView, InsertPersonMVPInteractor>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_insert_person, container, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_insert_person)

        dialog.window?.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)

        return dialog
    }
}