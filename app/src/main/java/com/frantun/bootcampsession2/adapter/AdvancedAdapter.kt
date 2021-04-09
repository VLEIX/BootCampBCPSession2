package com.frantun.bootcampsession2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.frantun.bootcampsession2.R

class AdvancedAdapter(private val items: List<String>) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        // condiciones
        return if (position % 2 == 0) {
            TYPE_1
        } else {
            TYPE_2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_1 -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_view,
                    parent,
                    false
                )
                ViewHolder1(view)
            }
            TYPE_2 -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_view_2,
                    parent,
                    false
                )
                ViewHolder2(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = items[position]
        when (holder) {
            is ViewHolder1 -> holder.bind(item) // esto puede variar dependiendo al modelo de datos
            is ViewHolder2 -> holder.bind(item)
            else -> throw IllegalArgumentException()
        }
    }

    class ViewHolder1(view: View) : BaseViewHolder<String>(view) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.name_text_view)

        override fun bind(item: String) {
            nameTextView.text = item
        }
    }

    class ViewHolder2(view: View) : BaseViewHolder<String>(view) {
        private val brandTextView = itemView.findViewById<TextView>(R.id.brand_text_view)

        override fun bind(item: String) {
            brandTextView.text = item
        }
    }

    companion object {
        private const val TYPE_1 = 0
        private const val TYPE_2 = 1
    }
}