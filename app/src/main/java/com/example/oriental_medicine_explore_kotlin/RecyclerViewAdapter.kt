package com.example.oriental_medicine_explore_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter constructor(context: Context, var onDeleteListener : MainViewModel) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
{

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<Entity>() // Cached copy of words


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val num1 = itemView.text
        val deletebutton = itemView.delete_button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val num = users[position]
        holder.num1.text = num.number1

        holder.deletebutton.setOnClickListener(View.OnClickListener {
            onDeleteListener.deleteAll(num)
            return@OnClickListener
        })
    }

    internal fun setUsers(users: List<Entity>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size
}

