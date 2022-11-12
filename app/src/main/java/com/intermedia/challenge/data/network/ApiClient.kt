package com.intermedia.challenge.data.network

import com.intermedia.challenge.data.model.CharactersModel
import com.intermedia.challenge.data.model.EventsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timeStamp: Int,
    ): CharactersModel

    @GET("v1/public/events")
    suspend fun getEvents(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timeStamp: Int,
    ): EventsModel

}