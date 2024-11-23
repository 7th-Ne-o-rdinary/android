package com.example.hackathon.presentation.groupcreation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hackathon.presentation.model.PrizeCreation

class GroupCreationViewModel : ViewModel() {
    private val _prizes = MutableLiveData<MutableList<PrizeCreation>>(mutableListOf())
    val prizes: LiveData<MutableList<PrizeCreation>> get() = _prizes

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
        val currentPrizes = _prizes.value ?: mutableListOf()
        val newIndex = currentPrizes.size + 1
        currentPrizes.add(
            PrizeCreation(index = newIndex, title = "", question = "", description = "")
        )
        _prizes.value = currentPrizes
    }

    fun updatePrize(updatedPrize: PrizeCreation) {
        val currentPrizes = _prizes.value?.toMutableList() ?: mutableListOf()
        val index = currentPrizes.indexOfFirst { it.index == updatedPrize.index }
        if (index != -1) {
            currentPrizes[index] = updatedPrize
            _prizes.value = currentPrizes
        }
    }

    fun getPrizes(): List<PrizeCreation> {
        return _prizes.value ?: emptyList()
    }
}
