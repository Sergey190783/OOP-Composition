package ru.netology.post.attachment

data class EventAttachment(override val type: String = "Event", val event: Event): Attachment()
