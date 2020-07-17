package com.example.qkc.data.network.response

import com.example.qkc.data.db.entity.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)