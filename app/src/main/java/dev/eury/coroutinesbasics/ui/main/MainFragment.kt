package dev.eury.coroutinesbasics.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.ui.main.adapters.CreatePostClickedAction
import dev.eury.coroutinesbasics.ui.main.adapters.MainAdapter
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenItemAction
import dev.eury.coroutinesbasics.ui.main.adapters.PostClickedAction

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private val adapter = MainAdapter(::onAction)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.moduleListLiveData.observe(::getLifecycle) {
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

    override fun onResume() {
        super.onResume()

    }


    fun onAction(action: MainScreenItemAction) {
        when (action) {
            is PostClickedAction -> {
               val post = action.post

                val direction = MainFragmentDirections.actionFirstFragmentToSecondFragment(post.id ?: 0)
                findNavController().navigate(direction)
            }
            is CreatePostClickedAction -> {
                findNavController().navigate(MainFragmentDirections.toPostCreate())
            }
        }
    }
}