package com.example.denis.databaseroom.ui.main.pack

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_package.*
import javax.inject.Inject

/**
 * Created by denis on 14/12/2017.
 */
class PackageFragment: BaseFragment(), PackageMvpView {
    companion object {
        fun newInstance(): PackageFragment {
            val args = Bundle()
            val fragment = PackageFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject lateinit var presenter: PackageMvpPresenter<PackageMvpView>

    @Inject lateinit var adapter: PackageAdapter

    @Inject lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_package, container, false)

        val component = getActivityComponent()

        component?.inject(this)
        presenter.onAttach(this)

        return view
    }


    override fun setUp(view: View?) {
        recyclerView.layoutManager = layoutManager
        recyclerView.setItemViewCacheSize(30)
        recyclerView.isDrawingCacheEnabled = true
        recyclerView.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, layoutManager.orientation))
        recyclerView.adapter = adapter
        adapter.setRecyclerView(recyclerView, layoutManager)

        presenter.getPackages()
    }

    override fun updateArrayList(array: ArrayList<MyDatabase>) {
        adapter.insertItems(array)
    }
}