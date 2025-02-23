package ru.netology

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val created_by: Int,
    val date: Int,
    val text: String,
    val reply_owner_id: Int,
    val reply_post_id: Int,
    val friends_only: Boolean,

) {

}

fun main (){
    val post = Post(1,1,1,1,1,"Привет!", 1, 1 , false)
    println(post)
}