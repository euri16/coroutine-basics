package dev.eury.coroutinesbasics.ui.main

import androidx.lifecycle.*
import dev.eury.coroutinesbasics.data.local.PostRepository
import dev.eury.coroutinesbasics.data.local.UserRepository
import dev.eury.coroutinesbasics.data.models.Album
import dev.eury.coroutinesbasics.data.models.Post
import dev.eury.coroutinesbasics.data.models.Todo
import dev.eury.coroutinesbasics.ui.main.adapters.*
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private val _moduleListLiveData = MutableLiveData<List<MainScreenListItem>>()
    val moduleListLiveData: LiveData<List<MainScreenListItem>> = _moduleListLiveData

    private var moduleList: List<MainScreenListItem> = listOf()
        set(value) {
            _moduleListLiveData.postValue(value)
        }

    private val userRepository = UserRepository()
    private val postRepository = PostRepository()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val albums = async { userRepository.getAlbums() }
            val todos = async { userRepository.getTodos() }
            val posts = async { postRepository.getPosts() }

            processData(albums.await(), todos.await(), posts.await())
        }
    }

    private fun processData(albums: List<Album>, todos: List<Todo>, posts: List<Post>) {
        moduleList = listOf(
            CreatePostListItem,
            TitleListItem("Albums", ItemType.ALBUM, isSeeAllVisible = false),
            AlbumListItem(albums),
            TitleListItem("TO-DOs", ItemType.TODOs, isSeeAllVisible = false),
            TodosListItem(todos),
            TitleListItem("Posts", ItemType.TODOs, isSeeAllVisible = false),
            PostsListItem(posts)
        )
    }
}