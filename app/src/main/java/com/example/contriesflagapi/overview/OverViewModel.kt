package com.example.contriesflagapi.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contriesflagapi.network.CountryApi
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*

class OverViewModel: ViewModel()  {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    /**
     * Call getCountryPhotos() on init so we can display status immediately.
     */
    init {
        getCountryPhotos()
    }

    /**
     * Gets Countries photos information from the countries snow API Retrofit service and updates the
     * [CountriesPhoto] [List] [LiveData].
     */

    private fun getCountryPhotos() {
        viewModelScope.launch {
            try {
                val listResult = CountryApi.retrofitService.getPhotos()

                _status.value =  "Success: ${listResult.size} Mars photos retrieved"
            }

            catch (e: Exception) {
                _status.value="Failure: ${e.message} "
            }
        }
    }


}