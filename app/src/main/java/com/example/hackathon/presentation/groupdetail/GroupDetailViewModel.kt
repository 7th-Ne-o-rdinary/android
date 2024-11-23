package com.example.hackathon.presentation.groupdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathon.data.GroupRepository
import com.example.hackathon.presentation.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GroupDetailViewModel : ViewModel() {
    private val repository = GroupRepository()

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchParticipantList(groupCode: String) {
        viewModelScope.launch {
            val result = repository.getParticipantList(groupCode)
            result.onSuccess { userList ->
                _users.value = userList
            }.onFailure { exception ->
                _error.value = exception.message
            }
        }
    }
}
