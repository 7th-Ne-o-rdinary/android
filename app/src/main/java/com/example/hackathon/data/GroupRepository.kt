package com.example.hackathon.data

import com.example.hackathon.presentation.model.Answer
import com.example.hackathon.presentation.model.GroupDetail
import com.example.hackathon.presentation.model.Prize
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
    fun canStartQuiz(code: String): Boolean = true

    // 답안 제출
    fun submitAnswers(
        code: String,
        answers: List<Answer>,
    ): Result<Unit> = runCatching { }

    // 결과 확인 가능 한가
    fun isAwardCompleted(code: String): Boolean = true

    // 시상 결과 불러오기
    fun getAwardResults(code: String): Result<List<PrizeResult>> = runCatching { DUMMY_AWARD_RESULTS }

    companion object {
        const val DUMMY_GROUP_CODE = "4567"

        // 더미 그룹 세부 정보
        val DUMMY_GROUP_DETAIL = GroupDetail(
            code = DUMMY_GROUP_CODE,
            groupLeader = "로빈",
            groupName = "3학년 1반",
            prizeList = listOf(
                Prize(
                    id = 1,
                    title = "재미상",
                    question = "누가 제일 웃기나요?",
                    description = "웃겨줘서 고마워"
                ),
                Prize(
                    id = 2,
                    title = "먹보상",
                    question = "누가 제일 많이 먹나요?",
                    description = "많이 먹어서 고마워. 보는 내가 배부르다."
                )
            )
        )

        // 더미 유저 데이터
        val DUMMY_USERS = listOf(
            User(id = "1", name = "로빈"),
            User(id = "2", name = "신구"),
            User(id = "3", name = "똘이"),
            User(id = "4", name = "상우")
        )

        // 더미 시상 결과
        val DUMMY_AWARD_RESULTS = listOf(
            PrizeResult(
                user = User(id = "1", name = "로빈"),
                prize = Prize(
                    id = 1,
                    title = "재미상",
                    question = "누가 제일 웃기나요?",
                    description = "웃겨줘서 고마워"
                )
            ),
            PrizeResult(
                user = User(id = "2", name = "신구"),
                prize = Prize(
                    id = 2,
                    title = "먹보상",
                    question = "누가 제일 많이 먹나요?",
                    description = "많이 먹어서 고마워. 보는 내가 배부르다."
                )
            )
        )
    }
}
