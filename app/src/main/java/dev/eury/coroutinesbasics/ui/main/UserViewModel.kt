package dev.eury.coroutinesbasics.ui.main

import android.util.Log
import androidx.lifecycle.*
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Comment
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenListItem
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    private val albumsLiveData = MutableLiveData<List<Album>>()
    private val todosLiveData = MutableLiveData<List<Todo>>()
    private val postsLiveData = MutableLiveData<List<Post>>()

    private val _moduleListLiveData = MutableLiveData<List<MainScreenListItem>>()
    val moduleListLiveData: LiveData<List<MainScreenListItem>> = _moduleListLiveData

    private var moduleList: List<MainScreenListItem> = listOf()
        set(value) {
            _moduleListLiveData.postValue(value)
        }

    private val userRepository = UserRepository()

    init {
        viewModelScope.launch {
            getAlbums()
            getTodos()
            getPosts()
        }
    }

    private fun getAlbums() {
        userRepository.getAlbums(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albumsLiveData.value = response.body() ?: listOf()
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
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

    private fun getPosts() {
        userRepository.getPosts(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postsLiveData.value = response.body() ?: listOf()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

    fun getComments(postId:Int) {
        userRepository.getComments(postId, object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                Log.d("", "")
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Log.d("", "")
            }
        })
    }
}