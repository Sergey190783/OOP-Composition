package ru.netology.post

data class Likes(
    val count: Int,
    val userLikes: Int,
    val canLike: Int,
    val canPublish: Int
)
