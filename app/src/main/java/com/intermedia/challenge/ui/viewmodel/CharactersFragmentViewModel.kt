package com.intermedia.challenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermedia.challenge.data.model.Result
import com.intermedia.challenge.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersFragmentViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val mldCharacters = MutableLiveData<List<Result>>()

    fun getCharacters() {
        viewModelScope.launch {
            val result = getCharactersUseCase()

            mldCharacters.postValue(result)
        }
    }

}