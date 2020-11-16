package dev.eury.coroutinesbasics.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.ui.main.adapters.MainAdapter
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenItemAction

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private val userViewModel:UserViewModel by activityViewModels()
    private val adapter = MainAdapter(::onAction)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel.moduleListLiveData.observe(::getLifecycle) {
            adapter.items = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.findViewById<RecyclerView>(R.id.rv_items).apply {
            adapter = this@MainFragment.adapter
        }
        return view
    }


    fun onAction(action:MainScreenItemAction) {

    }
}