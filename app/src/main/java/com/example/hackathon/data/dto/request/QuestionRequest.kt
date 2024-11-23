package com.example.hackathon.data.dto.request

data class QuestionRequest(
    val question_content: String,
    val question_num: Int,
    val prize_name: String,
    val prize_content: String,
)
