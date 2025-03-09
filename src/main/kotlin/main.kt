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
    val original: Post? = null,
    var attachments: Array <Attachment> = emptyArray(),
    var likes: Likes = Likes(0, false, false, false),
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean,
)

data class Sizes(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int,
)

data class Images(
    val url: String,
    val width: Int,
    val height: Int,
)

interface Attachment {
    val type: String
    val id: Int
    val ownerId: Int
}

class Video(
    override val type: String,
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val artist: String,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val duration: Int,
    val noSearch: Boolean,
    val isHq: Boolean
) : Attachment {
}

class Photo(
    override val type: String,
    override val id: Int,
    override val ownerId: Int,
    val AlbumId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int,
    val sizes: Array <Sizes>,
) : Attachment {
}

class Note(
    override val type: String,
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int,
    val readComments: Int,
    val viewUrl: String
) : Attachment {
}

class Page(
    override val type: String,
    override val id: Int,
    override val ownerId: Int,
    val groupId: Int,
    val creatorId: Int,
    val title: String,
    val currentUserCanEdit: Boolean,
    val currentUserCanEditAccess: Boolean,
    val whoCanView: Boolean,
    val whoCanEdit: Boolean,
    val edited: Int,
    val created: Int,
    val editorId: Int,
    val views: Int,
    val parent: String,
    val parent2: String,
    val source: String,
    val html: String,
    val viewUrl: String
) : Attachment {
}

class Sticker(
    override val type: String,
    override val id: Int,
    override val ownerId: Int,
    val productId: Int,
    val stickerId: Int,
    var images: Array <Images>,
    var imagesWithBackground: Array <Images>,
): Attachment{

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
        for ((index, postItem) in posts.withIndex()) {
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