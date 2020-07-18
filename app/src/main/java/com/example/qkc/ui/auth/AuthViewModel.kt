package com.example.qkc.ui.auth

import androidx.lifecycle.ViewModel
import com.example.qkc.data.db.entity.User
import com.example.qkc.data.repository.UserRepository

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(
        email: String,
        password: String
    ) = repository.userLogin(email, password)

    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)

}