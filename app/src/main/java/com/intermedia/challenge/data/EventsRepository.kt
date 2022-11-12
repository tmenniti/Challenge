package com.intermedia.challenge.data
import com.intermedia.challenge.data.model.EventProvider
import com.intermedia.challenge.data.model.EventsModel
import com.intermedia.challenge.data.network.EventsService
import javax.inject.Inject

class EventsRepository @Inject constructor(
    private val api : EventsService,
    private val characterProvider : EventProvider
) {

    suspend fun getEvents(): EventsModel {
        val response = api.getEvents()
        characterProvider.eventList = response.data.results
        return response
    }

}