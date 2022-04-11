package ru.netology.post.attachment

data class GraffitiAttachment(override val type: String = "Graffiti", val graffiti: Graffiti): Attachment()
