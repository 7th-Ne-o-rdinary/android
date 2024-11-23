package com.example.hackathon.data.api

import com.example.hackathon.data.dto.request.RoomCreationRequest
import com.example.hackathon.data.dto.request.VoteRequest
import com.example.hackathon.data.dto.response.QuestionResponse
import com.example.hackathon.data.dto.response.RoomStatusResponse
import com.example.hackathon.data.dto.response.VoteResponse
import com.example.hackathon.data.dto.response.VoteResultResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GroupService {
    //    Vote
    @POST("/api/v1/vote")
    suspend fun vote(
        @Body voteRequest: VoteRequest,
    ): Response<VoteResponse>

    @GET("/api/v1/vote/{roomId}")
    suspend fun getVoteResult(
        @Path("roomId") roomId: Int,
    ): Response<VoteResultResponse>

    //    Room
    @POST("/api/v1/rooms")
    suspend fun createRoom(
        @Body roomCreationRequest: RoomCreationRequest,
    ): Response<Unit>

    @PATCH("/api/v1/rooms")
    suspend fun roomStatus(
        @Query("roomId") code: String,
    ): Response<RoomStatusResponse>

    @POST("/api/v1/rooms/join")
    suspend fun joinRoom(
        @Query("roomId") code: String,
    ): Response<Unit>

    @GET("/api/v1/rooms/participants}")
    suspend fun getParticipants(
        @Path("roomId") code: String,
    ): Response<VoteResultResponse>

    // Question
    @POST("/api/v1/question/create/{roomId}")
    suspend fun createQuestion(
        @Path("roomId") roomId: Int,
    ): Response<QuestionResponse>

    @GET("/api/v1/question/list/{roomId}")
    suspend fun getQuestionList(
        @Path("roomId") roomId: Int,
    ): Response<List<QuestionResponse>>
}
