package dev.eury.coroutinesbasics.ui.main.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.ui.main.adapters.TodosListItem
import dev.eury.coroutinesbasics.ui.main.adapters.todos.TodoAdapter

class TodoListViewHolder(view: View) : BaseViewHolder<TodosListItem>(view) {

    private val recyclerView = view.findViewById<RecyclerView>(R.id.rv_data)

    private val adapter = TodoAdapter()

    init {
        recyclerView.adapter = adapter
    }

    override fun bind(item: TodosListItem) {
        adapter.items = item.todos
    }
}