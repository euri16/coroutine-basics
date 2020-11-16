package dev.eury.coroutinesbasics.ui.main.adapters.todos

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.utils.inflate

class TodoAdapter() : RecyclerView.Adapter<TodoViewHolder>() {

    var items: List<Todo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(parent.inflate(R.layout.itv_todo))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count()
}