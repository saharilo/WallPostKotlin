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


fun main() {
    val post = Post(1, 1, 1, 1, 1, "Привет!", 1, 1, false)
    println(post)
}