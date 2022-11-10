package com.intermedia.challenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermedia.challenge.data.model.EventResult
import com.intermedia.challenge.domain.GetEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsFragmentViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    val mldEvents = MutableLiveData<List<EventResult>>()

    fun getEvents() {
        viewModelScope.launch {
            val result = getEventsUseCase()

            mldEvents.postValue(result)
        }
    }

}