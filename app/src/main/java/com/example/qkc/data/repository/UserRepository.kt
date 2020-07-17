package com.example.qkc.data.repository

import com.example.qkc.data.network.ApiService
import com.example.qkc.data.network.response.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return ApiService().userLogin(email, password)
    }

}