package dev.eury.coroutinesbasics.ui.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import dev.eury.coroutinesbasics.R
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.ui.post.adapter.CommentAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PostFragment : Fragment() {

    private val args: PostFragmentArgs by navArgs()

    private val postViewModel: PostViewModel by viewModels()

    private val adapter = CommentAdapter()

    private lateinit var tvPostTitle:TextView
    private lateinit var tvPostContent:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postViewModel.postDataLiveData.observe(::getLifecycle) {
            adapter.items = it.comments
            showPostData(it.post)
        }

        postViewModel.fetchPostData(args.postId)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPostTitle = view.findViewById(R.id.tv_post_title)
        tvPostContent = view.findViewById(R.id.tv_post_body)

        view.findViewById<RecyclerView>(R.id.rv_comments).apply {
            adapter = this@PostFragment.adapter
        }
    }

    private fun showPostData(post: Post) {
        tvPostTitle.text = post.title
        tvPostContent.text = post.body
    }
}