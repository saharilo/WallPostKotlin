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
    private var nextId = 0

    fun add(post: Post): Post {
        val postAdded = post.copy(id = nextId)
        posts += postAdded
        nextId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val (indexPost) = post
        for((index, postItem) in posts.withIndex()){
            val (postId) = postItem
            if (postId == indexPost) {
                posts[indexPost] = post
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        nextId = 0
    }

    fun getPostByIndex(index: Int): Post {
        return posts[index]
    }
}

fun main() {
    val post = Post(text = "Привет!")
    val post2 = Post(text = "Привет2!")
    val post3 = Post(1, text = "Привет3!")

    val result1 = WallService.add(post)
    val result2 = WallService.add(post2)
    println(result1)
    println(result2)
    WallService.update(post3)
    println(WallService.getPostByIndex(1))
}