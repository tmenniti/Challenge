package com.intermedia.challenge.data.model

import java.io.Serializable

data class CharactersModel(
    val code: String,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: Data,
    val etag: String
) : Serializable

data class Data (
    val offset: String,
    val limit: String,
    val total: String,
    val count: String,
    val results: List<Result>
) : Serializable

data class Result (
    val id: String,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val urls: List<URL>,
    val thumbnail: Thumbnail,
    val comics: Comics,
    val stories: Stories,
    val events: Comics,
    val series: Comics
) : Serializable

data class Comics (
    val available: String,
    val returned: String,
    val collectionURI: String,
    val items: List<ComicsItem>
) : Serializable

data class ComicsItem (
    val resourceURI: String,
    val name: String
) : Serializable

data class Stories (
    val available: String,
    val returned: String,
    val collectionURI: String,
    val items: List<StoriesItem>
) : Serializable

data class StoriesItem (
    val resourceURI: String,
    val name: String,
    val type: String
) : Serializable

data class Thumbnail (
    val path: String,
    val extension: String
) : Serializable

data class URL (
    val type: String,
    val url: String
) : Serializable
