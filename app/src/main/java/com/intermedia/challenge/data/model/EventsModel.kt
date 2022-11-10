package com.intermedia.challenge.data.model

data class EventsModel(
    val code: String,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: EventData,
    val etag: String
)

data class EventData (
    val offset: String,
    val limit: String,
    val total: String,
    val count: String,
    val results: List<EventResult>
)

data class EventResult (
    val id: String,
    val title: String,
    val description: String,
    val resourceURI: String,
    val urls: List<EventURL>,
    val modified: String,
    val start: String,
    val end: String,
    val thumbnail: EventThumbnail,
    val comics: EventComics,
    val stories: EventStories,
    val series: EventComics,
    val characters: EventCharacters,
    val creators: EventCharacters,
    val next: EventNext,
    val previous: EventNext
)

data class EventCharacters (
    val available: String,
    val returned: String,
    val collectionURI: String,
    val items: List<CharactersItem>
)

data class CharactersItem (
    val resourceURI: String,
    val name: String,
    val role: String
)

data class EventComics (
    val available: String,
    val returned: String,
    val collectionURI: String,
    val items: List<EventNext>
)

data class EventNext (
    val resourceURI: String,
    val name: String
)

data class EventStories (
    val available: String,
    val returned: String,
    val collectionURI: String,
    val items: List<EventStoriesItem>
)

data class EventStoriesItem (
    val resourceURI: String,
    val name: String,
    val type: String
)

data class EventThumbnail (
    val path: String,
    val extension: String
)

data class EventURL (
    val type: String,
    val url: String
)