package com.example.hackathon.presentation.model

// 방에 대한 자세한 정보들을 얻는다.
data class GroupDetail(
    val code: String,
    val groupLeader: String,
    val groupName: String,
    val prizeList: List<Prize>, // 상 목록
)
