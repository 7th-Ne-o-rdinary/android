package com.example.hackathon.data

import com.example.hackathon.presentation.model.Answer
import com.example.hackathon.presentation.model.GroupDetail
import com.example.hackathon.presentation.model.PrizeCreation
import com.example.hackathon.presentation.model.PrizeResult
import com.example.hackathon.presentation.model.User

class GroupRepository {
    // 방 생성 - string 코드 반환
    fun createGroup(
        title: String,
        prizes: List<PrizeCreation>,
    ): Result<String> = runCatching { DUMMY_GROUP_CODE }

    // 방에 대한 자세한 정보 제공
    fun getGroupByCode(code: String): Result<GroupDetail> = runCatching { DUMMY_GROUP_DETAIL }

    // 참여 중인 유저 리스트 불러오기
    fun getParticipantList(code: String): Result<List<User>> = runCatching { DUMMY_USERS }

    // 설문 시작할 수 있나요
    fun canStartQuiz(code: String): Boolean = false

    // 답안 제출
    fun submitAnswers(
        code: String,
        answers: List<Answer>,
    ): Result<Unit> = runCatching { }

    // 결과 확인 가능 한가
    fun isAwardCompleted(code: String): Boolean = false

    // 시상 결과 불러오기
    fun getAwardResults(code: String): Result<List<PrizeResult>> = runCatching { listOf() }

    companion object {
        const val DUMMY_GROUP_CODE = "sampleCode"
        val DUMMY_GROUP_DETAIL =
            GroupDetail(code = DUMMY_GROUP_CODE, groupLeader = "0", groupName = "더미 그룹 이름", prizeList = listOf())
        val DUMMY_USERS = listOf(User("", "마로"), User("", "심바"), User("", "예니"))
    }
}
