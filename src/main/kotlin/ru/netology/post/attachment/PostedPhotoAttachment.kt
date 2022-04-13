package ru.netology.post.attachment

data class PostedPhotoAttachment(override val type: String = "PostedPhoto", val postedPhoto: PostedPhoto): Attachment()