package com.example.hackathon.presentation.model

// 방에 대한 자세한 정보들을 얻는다.
data class GroupDetail(
    val groupId: Int,
    val groupLeaderId: Int,
    val groupName: String,
    val prizeList: List<Prize>, // 상 목록
    val code: String,
)
