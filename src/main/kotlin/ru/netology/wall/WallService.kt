package ru.netology.wall

import ru.netology.post.*

class WallService() {
    private val posts:MutableList<Post> = mutableListOf()
    private fun getId(): Int{
        return if(posts.isNotEmpty()){
            posts.last().id + 1
        }else{
            1
        }
    }
    fun getPost(index: Int):Post{
        return posts[index]
    }
    fun add(post: Post): Post {
        val newPost = post.copy(id = getId())
        posts.add(newPost)
        return newPost
    }
    /**
     * Обновление записи по id
     */
    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { p -> p.id == post.id }
        return if (index != -1) {
            posts[index] = post.copy(ownerId = posts[index].ownerId, date = posts[index].date)
            true
        } else {
            false
        }
    }
}