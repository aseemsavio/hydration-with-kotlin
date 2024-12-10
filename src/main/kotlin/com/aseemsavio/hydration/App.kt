package com.aseemsavio.hydration

import com.aseemsavio.hydration.app.PostServiceClient
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val postService = PostServiceClient()

        for (post in postService.posts()) {
            
        }
    }
}
