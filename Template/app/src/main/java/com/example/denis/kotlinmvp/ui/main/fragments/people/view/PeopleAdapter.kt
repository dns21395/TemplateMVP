package com.example.denis.kotlinmvp.ui.main.fragments.people.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import kotlinx.android.synthetic.main.holder_person.view.*

/**
 * Created by denis on 31/01/2018.
 */
class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {
    private var array = ArrayList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonViewHolder =
        PersonViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.holder_person, parent, false))

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: PersonViewHolder?, position: Int) {
        holder?.onBind(array[position])
    }

    fun updateArray(array: ArrayList<Person>) {
        this.array = array
        notifyDataSetChanged()
    }

    inner class PersonViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun onBind(person: Person) = with(itemView) {
            name.text = person.name
            age.text = person.age.toString()
        }
    }
}