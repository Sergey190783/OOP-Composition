package ru.netology.post.attachment

data class AppAttachment(override val type: String = "App", val app: App): Attachment()
