package com.example.jetpackapi.model

data class Apple(
    val results: Feed.Result
) {
    data class Feed(
        val author: Author,
        val copyright: String,
        val country: String,
        val icon: String,
        val id: String,
        val links: List<Link>,
        val results: List<Result>,
        val title: String,
        val updated: String
    ) {
        data class Author(
            val name: String,
            val url: String
        )

        data class Link(
            val self: String
        )

        data class Result(
            val artistName: String,
            val artworkUrl100: String,
            val genres: List<String>,
            val id: String,
            val kind: String,
            val name: String,
            val releaseDate: String,
            val url: String
        )
    }
}