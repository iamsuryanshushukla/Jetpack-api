package com.example.jetpackapi.model

import com.example.jetpackapi.R

data class ImageAndText(var image: Int, val text :String)

fun list():List<ImageAndText>{
    var List = listOf(
        ImageAndText(R.drawable.doge,"Doge To Moon"),
                ImageAndText(R.drawable.paisa,"Doge To Moon"),
    ImageAndText(R.drawable.doges,"Doge To Moon"),
    ImageAndText(R.drawable.paisa,"Doge To Moon"),
    ImageAndText(R.drawable.paisa,"Doge To Moon"),
    ImageAndText(R.drawable.paisa,"Doge To Moon"),
    ImageAndText(R.drawable.paisa,"Doge To Moon")
    )


    return List
}
