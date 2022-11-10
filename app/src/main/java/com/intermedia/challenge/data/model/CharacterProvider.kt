package com.intermedia.challenge.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterProvider @Inject constructor() {
    var charactersList : List<Result> = listOf()
}