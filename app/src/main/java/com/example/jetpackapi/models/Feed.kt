package com.example.apicalling.models

data class Feed(
    val author: Author,
    val copyright: String,
    val country: String,
    val icon: String,
    val id: String,
    val links: ArrayList<Link>,
    val results: ArrayList<Result>,
    val title: String,
    val updated: String
)