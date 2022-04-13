package ru.netology.post.comment

data class Thread(

    val count: Int,
    val items: MutableList<Comment>,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
)
