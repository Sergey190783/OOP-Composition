package ru.netology.post

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val canPublishFreeCopy: Boolean,
    val placeholder: Placeholder,
    val editMode: String
)
