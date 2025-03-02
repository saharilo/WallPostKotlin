package ru.netology

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    var likes: Likes = Likes(0, false, false, false),
) {

}

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean,
) {

}

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun add(post: Post): Post {
        posts += post.copy(id = nextId)
        nextId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val indexPost = posts.indexOf(post)
        if (indexPost < 0) return false
        posts[indexPost] = post
        return true
    }

    fun clear() {
        posts = emptyArray()
        nextId = 1
    }
}

fun main() {
    val post = Post(text = "Привет!")
    val post2 = Post(text = "Привет2!")

    WallService.add(post)
    println(post)
    WallService.update(post2)
    println(post2)
}