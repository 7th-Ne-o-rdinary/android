package com.example.hackathon.data.dto.request

data class RoomCreationRequest(
    val name: String,
    val questions: List<Question>,
)

data class Question(
    val question_num: Int,
    val question_content: String,
    val prize_name: String,
    val prize_content: String,
)
