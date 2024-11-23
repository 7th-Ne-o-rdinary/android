package com.example.hackathon.presentation.groupcreation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathon.data.GroupRepository
import com.example.hackathon.presentation.model.PrizeCreation
import kotlinx.coroutines.launch

class GroupCreationViewModel : ViewModel() {
    private val repository = GroupRepository()

    private val _prizes = MutableLiveData<MutableList<PrizeCreation>>(mutableListOf())
    val prizes: LiveData<MutableList<PrizeCreation>> get() = _prizes

    private val _groupCreationState = MutableLiveData<GroupCreationState>()
    val groupCreationState: LiveData<GroupCreationState> get() = _groupCreationState

    init {
        // 최소 하나의 기본 항목 추가
        ensureAtLeastOnePrize()
    }

    private fun ensureAtLeastOnePrize() {
        if (_prizes.value.isNullOrEmpty()) {
            _prizes.value = mutableListOf(
                PrizeCreation(index = 1, title = "", question = "", description = "")
            )
        }
    }

    fun addPrize() {
        val newPrize = PrizeCreation(
            index = (_prizes.value?.size ?: 0) + 1,
            title = "",
            question = "",
            description = ""
        )
        val updatedPrizes = _prizes.value ?: mutableListOf()
        updatedPrizes.add(newPrize)
        _prizes.value = updatedPrizes
    }

    fun getPrizes(): List<PrizeCreation> {
        return _prizes.value ?: emptyList()
    }

    fun createGroup(title: String, prizes: List<PrizeCreation>) {
        _groupCreationState.value = GroupCreationState.Loading
        viewModelScope.launch {
            val result = repository.createGroup(title, prizes)
            if (result.isSuccess) {
                _groupCreationState.postValue(GroupCreationState.Success)
            } else {
                _groupCreationState.postValue(
                    GroupCreationState.Error("그룹 생성에 실패했습니다: ${result.exceptionOrNull()?.message}")
                )
            }
        }
    }

    sealed class GroupCreationState {
        object Success : GroupCreationState()
        data class Error(val message: String) : GroupCreationState()
        object Loading : GroupCreationState()
    }
}
