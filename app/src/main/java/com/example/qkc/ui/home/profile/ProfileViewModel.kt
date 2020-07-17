package com.example.qkc.ui.home.profile

import androidx.lifecycle.ViewModel
import com.example.qkc.data.repository.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}