package com.example.qkc.data.repository

import com.example.qkc.data.db.AppDatabase
import com.example.qkc.data.db.entity.User
import com.example.qkc.data.network.ApiService
import com.example.qkc.data.network.SafeApiRequest
import com.example.qkc.data.network.response.AuthResponse

class UserRepository(
    private val api: ApiService,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()
}