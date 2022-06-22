package dev.eury.coroutinesbasics.ui.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.local.SessionManager
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.ui.post.adapter.CommentAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PostCreateFragment : Fragment() {

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postViewModel.postCreateLiveData.observe(::getLifecycle) {
            Toast.makeText(requireContext(), "Post Created", Toast.LENGTH_LONG).show()
            findNavController().popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etPost = view.findViewById<EditText>(R.id.et_post)

        view.findViewById<Button>(R.id.btnPost).setOnClickListener {
            val newPost = Post(
                userId = SessionManager.USER_ID,
                title = "Some title",
                body = etPost.text.toString()
            )
            postViewModel.createPost(newPost)
        }
    }
}