package com.example.qkc.data.network.response

import com.example.qkc.data.db.entity.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)