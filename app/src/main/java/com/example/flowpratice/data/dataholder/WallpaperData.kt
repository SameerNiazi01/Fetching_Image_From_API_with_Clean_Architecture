package com.example.flowpratice.data.dataholder

data class WallpaperData(  val total: Long,
                           val totalHits: Long,
                           val hits: List<Hit>)
data class Hit (
    val id: Long,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Long,
    val previewHeight: Long,
    val webformatURL: String,
    val webformatWidth: Long,
    val webformatHeight: Long,
    val largeImageURL: String,
    val imageWidth: Long,
    val imageHeight: Long,
    val imageSize: Long,
    val views: Long,
    val downloads: Long,
    val collections: Long,
    val likes: Long,
    val comments: Long,

  //  @Json(name = "user_id")
    val user_id: Long,

    val user: String,
    val userImageURL: String
)