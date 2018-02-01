package com.example.denis.kotlinmvp.ui.main.fragments.people.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import kotlinx.android.synthetic.main.holder_person.view.*
import org.jetbrains.anko.backgroundColor

/**
 * Created by denis on 31/01/2018.
 */
class PeopleAdapter(private val context: Context) : RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {
    private val swipeCallback = PeopleAdapterSwipeCallback(context, this)
    val itemTouchHelper = ItemTouchHelper(swipeCallback)
    lateinit var callback: Callback
    private var array = ArrayList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonViewHolder =
        PersonViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.holder_person, parent, false))

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: PersonViewHolder?, position: Int) {
        holder?.onBind(array[position])
    }

    fun updateArray(array: ArrayList<Person>) {
        if(this.array.size <= array.size) {
            this.array = array
            notifyDataSetChanged()
        }
    }

    fun removeAt(position: Int) {
        callback.onRemovePerson(array[position])
        array.removeAt(position)
        notifyItemRemoved(position)
    }

    interface Callback {
        fun onRemovePerson(person: Person)
    }

    inner class PersonViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), ItemTouchHelperViewHolder {

        fun onBind(person: Person) = with(itemView) {
            name.text = person.name
            age.text = person.age.toString()

            setSwipe()
        }

        private fun setSwipe() {
            itemView.setOnLongClickListener {
                itemTouchHelper.startSwipe(this)
                false
            }
        }

        override fun onItemSelected() {
            changeBackground(R.color.colorPrimaryDark)
        }

        override fun onItemClear() {
            changeBackground(android.R.color.white)
        }

        fun changeBackground(color: Int) = with(itemView)  {
            itemView.backgroundColor = ContextCompat.getColor(context, color)
        }
    }
}