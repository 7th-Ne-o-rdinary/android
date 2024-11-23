package com.example.hackathon.presentation.prizeresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hackathon.data.GroupRepository
import com.example.hackathon.presentation.model.PrizeResult

class PrizeResultViewModel : ViewModel() {
    private val repository = GroupRepository() // 직접 Repository 생성

    fun isAwardCompleted(code: String): Boolean {
        return repository.isAwardCompleted(code)
    }

    private val _awardResults = MutableLiveData<List<PrizeResult>>()
    val awardResults: LiveData<List<PrizeResult>> get() = _awardResults

    fun fetchAwardResults(code: String) {
        val result = repository.getAwardResults(code)
        result.onSuccess { results ->
            _awardResults.value = results
        }.onFailure {
            _awardResults.value = emptyList() // 실패 시 빈 리스트로 설정
        }
    }
}

