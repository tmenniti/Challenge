package com.intermedia.challenge.domain

import com.intermedia.challenge.data.EventsRepository
import com.intermedia.challenge.data.model.EventResult
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val repository : EventsRepository
) {

    suspend operator fun invoke() : List<EventResult> = repository.getEvents().data.results

}