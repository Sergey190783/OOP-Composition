package ru.netology.post.attachment

data class Event(
    val id: Int,
    val time: Int,
    val memberStatus: Int,
    val isFavorite: Boolean,
    val address: String,
    val text: String,
    val buttonText: String,
    val friends: Int,
):Attachment("event")
