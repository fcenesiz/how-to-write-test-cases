package com.fcenesiz.shopping_list_testing.data.remote.responses


data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
)