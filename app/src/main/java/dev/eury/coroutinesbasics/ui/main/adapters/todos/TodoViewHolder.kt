package dev.eury.coroutinesbasics.ui.main.adapters.todos

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Todo

class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView = view.findViewById<TextView>(R.id.tv_todo_text)

    fun bind(item: Todo) {
        textView.text = item.title
    }
}