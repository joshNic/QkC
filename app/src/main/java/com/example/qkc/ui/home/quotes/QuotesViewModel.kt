package com.example.qkc.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.example.qkc.data.repository.QuotesRepository
import com.example.qkc.ui.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}