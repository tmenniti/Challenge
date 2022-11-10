package com.intermedia.challenge.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventProvider @Inject constructor() {
    var eventList : List<EventResult> = listOf()
}