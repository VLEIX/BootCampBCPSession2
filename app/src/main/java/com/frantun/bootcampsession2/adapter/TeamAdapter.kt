package com.frantun.bootcampsession2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.frantun.bootcampsession2.R
import com.frantun.bootcampsession2.interfaces.IOnEventClick

class TeamAdapter(private val items: List<String>, private val onEventListener: IOnEventClick) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.name_text_view)

        fun bind(item: String) {
            nameTextView.text = item

            itemView.setOnClickListener {
                onEventListener.onClick(adapterPosition)
            }
        }
    }
}
