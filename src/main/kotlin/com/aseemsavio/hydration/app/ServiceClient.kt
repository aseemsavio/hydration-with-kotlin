package com.aseemsavio.hydration.app

import kotlin.random.Random

data class Post(
    val id: Int,
    val title: String,
    val content: String
)

fun generateRandomString(length: Int): String {
    val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    return (1..length)
        .map { Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
}

interface ServiceClient {
    suspend fun posts(): Sequence<Post>
}

class PostServiceClient : ServiceClient {
    override suspend fun posts(): Sequence<Post> = sequence {
        for (i in 0..100_000) {
            yield(Post(id = i, title = generateRandomString(10), content = generateRandomString(5000)))
        }
    }
}
