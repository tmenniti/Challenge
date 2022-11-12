package com.intermedia.challenge.data.network

import com.intermedia.challenge.core.MD5_HASH
import com.intermedia.challenge.core.PUBLIC_KEY
import com.intermedia.challenge.data.model.CharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersService @Inject constructor(private val api : ApiClient) {

    suspend fun getCharacters() : CharactersModel {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters(PUBLIC_KEY, MD5_HASH, 1)
            response
        }
    }

}