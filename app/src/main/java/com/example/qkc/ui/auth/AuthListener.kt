package com.example.qkc.ui.auth

import com.example.qkc.data.db.entity.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}