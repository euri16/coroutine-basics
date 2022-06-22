package dev.eury.coroutinesbasics.ui.main

import android.util.Log
import androidx.lifecycle.*
import dev.eury.coroutinesbasics.data.local.PostRepository
import dev.eury.coroutinesbasics.data.local.UserRepository
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.ui.main.adapters.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val albumsLiveData = MutableLiveData<List<Album>>()
    private val todosLiveData = MutableLiveData<List<Todo>>()
    private val postsLiveData = MutableLiveData<List<Post>>()

    private val _moduleListLiveData = MutableLiveData<List<MainScreenListItem>>()
    val moduleListLiveData: LiveData<List<MainScreenListItem>> = _moduleListLiveData

    private val userRepository = UserRepository()
    private val postRepository = PostRepository()

    init {
        fetchData()
    }

    // TODO: refactor to use coroutines
    private fun fetchData() {
        getAlbums()
        getTodos()
        getPosts()
    }

    private fun getAlbums() {
        userRepository.getAlbums(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albumsLiveData.value = response.body() ?: listOf()
                processResponses()
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

    private fun getTodos() {
        userRepository.getTodos(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                todosLiveData.value = response.body() ?: listOf()
                processResponses()
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

    private fun getPosts() {
        postRepository.getPosts(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postsLiveData.value = response.body() ?: listOf()
                processResponses()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

    private fun processResponses() {
        val albums = albumsLiveData.value
        val todos = todosLiveData.value
        val posts = postsLiveData.value

        if (albums != null && todos != null && posts != null) {
            processData(albums, todos, posts)
        }
    }

    private fun processData(albums: List<Album>, todos: List<Todo>, posts: List<Post>) {
        _moduleListLiveData.postValue(
            listOf(
                CreatePostListItem,
                TitleListItem("Albums", ItemType.ALBUM, isSeeAllVisible = false),
                AlbumListItem(albums),
                TitleListItem("TO-DOs", ItemType.TODOs, isSeeAllVisible = false),
                TodosListItem(todos),
                TitleListItem("Posts", ItemType.TODOs, isSeeAllVisible = false),
                PostsListItem(posts)
            )
        )
    }
}