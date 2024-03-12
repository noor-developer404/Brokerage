package com.example.brokerage.models

data class loginModelItem(
    val day_start: Int,
    val emailId: String,
    val instId: String,
    val message: String,
    val next_day: Int,
    val pending_job: Int,
    val phone_no: String,
    val service_type: String,
    val status: Int,
    val sucessfully_complete: Int,
    val user_roles: String
)