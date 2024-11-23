package com.example.hackathon.data.dto.request

data class VoteRequest(
    val votePeopleEmail: String,
    val votedPeopleEmail: String,
    val questionId: Int,
)
