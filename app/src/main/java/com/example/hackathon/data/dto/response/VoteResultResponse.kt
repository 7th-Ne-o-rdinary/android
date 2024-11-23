package com.example.hackathon.data.dto.response

data class VoteResultResponse(
    val questionId: Int,
    val roomName: String,
    val prizeName: String,
    val userName: String,
    val prizeContent: String,
    val voteCount: Int,
)
