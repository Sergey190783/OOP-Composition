package ru.netology.wall

import ru.netology.post.*

class WallService(var posts: Array<Post>) {
    private var curId = 0
    fun getId() = this.curId
    fun add(post: Post): Post {
        val mutablePosts = posts.toMutableList()
        val newPost = post.copy(id = curId)
        curId++
        mutablePosts.add(newPost)
        posts = mutablePosts.toTypedArray()
        return newPost
    }

    /**
     * Обновление записи по id
     */
    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { p -> p.id == post.id }
        if (index != -1) {
            posts[index] = posts[index].copy(
                id = curId,
                fromId = post.fromId,
                createdBy = post.createdBy,
                text = post.text,
                replyOwnerId = post.replyOwnerId,
                replyPostId = post.replyPostId,
                friendsOnly = post.friendsOnly,
                comments = post.comments,
                copyright = post.copyright,
                likes = post.likes,
                reposts = post.reposts,
                views = post.views,
                postType = post.postType,
                signerId = post.signerId,
                canPin = post.canPin,
                canDelete = post.canDelete,
                canEdit = post.canEdit,
                isPinned = post.isPinned,
                markedAsAds = post.markedAsAds,
                isFavorite = post.isFavorite,
                donut = post.donut,
                postponedId = post.postponedId
            )
            return true
        } else {
            return false
        }
    }
}