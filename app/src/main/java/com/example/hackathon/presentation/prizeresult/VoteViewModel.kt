package com.example.hackathon.presentation.prizeresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VoteViewModel: ViewModel() {

    // 투표 항목과 결과를 저장
    private val _votes = MutableLiveData<Map<String, Int>> ()
    val votes : LiveData<Map<String,Int>> get() = _votes

    // 각 사용자별 선택을 저장
    private val userVotes = mutableMapOf<String, String>()


}