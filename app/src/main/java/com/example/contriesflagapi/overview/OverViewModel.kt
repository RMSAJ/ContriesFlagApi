package com.example.contriesflagapi.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contriesflagapi.network.CountryApi
import com.example.contriesflagapi.network.contriemodel
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*

class OverViewModel: ViewModel()  {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<contriemodel>()
    val photos: LiveData<contriemodel> = _photos

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
                _photos.value = CountryApi.retrofitService.getPhotos().data[0]

                _status.value =  "Success: ${_photos.value!!.flag} flags photos retrieved"
            }

            catch (e: Exception) {
                _status.value="Failure: ${e.message} "
            }
        }
    }


}