package com.intermedia.challenge.domain

import com.intermedia.challenge.data.CharactersRepository
import com.intermedia.challenge.data.model.Result
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository : CharactersRepository
) {

    suspend operator fun invoke() : List<Result> = repository.getCharacters().data.results

}