package com.example.demoapp.models

data class MessageChatEntity(
    val chatType: String? = "",
    var isHeader: Int = 0,
    val date: String? = "",
    val message: String? = "",
    val sectionDate: String? = "",
    val friendAvatar: Int? = 0
)
