package ru.netology.post.attachment

data class NoteAttachment(override val type: String = "Note", val note: Note): Attachment()
