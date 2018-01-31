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
import kotlinx.android.synthetic.main.dialog_insert_person.*
import org.jetbrains.anko.support.v4.toast
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
        setUp()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_insert_person, container, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_insert_person)

        dialog.window?.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)

        return dialog
    }

    private fun setUp() {
        cancel.setOnClickListener {
            closeDialog()
        }

        add.setOnClickListener {

            val ageLong: Int? = try {
                "${age.text.trim()}".toInt()
            } catch (e: Exception) { null }

            presenter.onButtonAddClicked(name.text.trim().toString(), ageLong)
        }
    }

    override fun showToast(toast: Int) {
        toast(toast)
    }

    override fun closeDialog() {
        dismissDialog(TAG)
    }
}