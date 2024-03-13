package com.example.brokerage.models

data class newsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)