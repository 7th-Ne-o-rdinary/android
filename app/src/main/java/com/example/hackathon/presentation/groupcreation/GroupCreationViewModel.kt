package com.example.hackathon.presentation.groupcreation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hackathon.presentation.model.PrizeCreation

class GroupCreationViewModel : ViewModel() {

    private val _prizes = MutableLiveData<MutableList<PrizeCreation>>(mutableListOf())
    val prizes: LiveData<MutableList<PrizeCreation>> get() = _prizes

    private var prizeIndex = 1

    fun addPrize(title: String, question: String, description: String) {
        val currentPrizes = _prizes.value ?: mutableListOf()
        currentPrizes.add(PrizeCreation(prizeIndex, title, question, description))
        _prizes.value = currentPrizes
        prizeIndex++
    }

    fun updatePrize(updatedPrize: PrizeCreation) {
        val currentPrizes = _prizes.value?.toMutableList() ?: mutableListOf()
        val index = currentPrizes.indexOfFirst { it.index == updatedPrize.index }
        if (index != -1) {
            currentPrizes[index] = updatedPrize
            _prizes.value = currentPrizes
        }
    }
}
