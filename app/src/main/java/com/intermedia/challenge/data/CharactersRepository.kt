package com.intermedia.challenge.data

import com.intermedia.challenge.data.model.CharacterProvider
import com.intermedia.challenge.data.model.CharactersModel
import com.intermedia.challenge.data.network.CharactersService
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api : CharactersService,
    private val characterProvider : CharacterProvider
) {

    suspend fun getCharacters(): CharactersModel {
        val response = api.getCharacters()
        characterProvider.charactersList = response.data.results
        return response
    }

}