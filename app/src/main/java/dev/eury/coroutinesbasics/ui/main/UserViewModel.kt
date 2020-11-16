package dev.eury.coroutinesbasics.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.eury.coroutinesbasics.ui.main.adapters.MainScreenListItem
import kotlinx.coroutines.*

class UserViewModel : ViewModel() {

    private var moduleList: List<MainScreenListItem> = listOf()
        set(value) {
            _moduleListLiveData.postValue(value)
        }

    private val _moduleListLiveData = MutableLiveData<List<MainScreenListItem>>()
    val moduleListLiveData: LiveData<List<MainScreenListItem>> = _moduleListLiveData

    init {
        viewModelScope.launch {

        }
    }
}