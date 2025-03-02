package ru.netology

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
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
    private var nextId = 0

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
}

fun main() {
    val post = Post(1, 1, 1, 1, 1, "Привет!", 1, 1, false)
    val post2 = Post(0, 1, 1, 1, 1, "Привет2!", 1, 1, false)

    WallService.add(post)
    println(post)
    WallService.update(post2)
    println(post2)
}