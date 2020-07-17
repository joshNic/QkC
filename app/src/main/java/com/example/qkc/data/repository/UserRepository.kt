package com.example.qkc.data.repository

import com.example.qkc.data.network.ApiService
import com.example.qkc.data.network.SafeApiRequest
import com.example.qkc.data.network.response.AuthResponse

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { ApiService().userLogin(email, password) }
    }
}