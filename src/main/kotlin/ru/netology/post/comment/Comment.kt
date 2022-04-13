package ru.netology.post.comment

import ru.netology.post.attachment.Attachment

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val postId: Int,
    val donut: Donut,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: MutableList<Attachment>,
    val parentsStack: MutableList<Int>,
    val thread: Thread

)
