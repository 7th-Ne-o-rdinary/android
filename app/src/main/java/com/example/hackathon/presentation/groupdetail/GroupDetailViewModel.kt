package com.example.hackathon.presentation.groupdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hackathon.presentation.model.User

class GroupDetailViewModel : ViewModel() {
    private val _users = MutableLiveData<MutableList<User>>(mutableListOf())
    val users: LiveData<MutableList<User>> get() = _users

    fun addUser(user: User) {
        val currentUsers = _users.value ?: mutableListOf()
        currentUsers.add(user)
        _users.value = currentUsers
    }

    fun setUsers(userList: List<User>) {
        _users.value = userList.toMutableList()
    }

    fun getUsers(): List<User> {
        return _users.value ?: emptyList()
    }
}
