package com.example.test3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng

class viewmodel:ViewModel() {

    private val _locationLiveData = MutableLiveData<LatLng>()
    val locationLiveData: LiveData<LatLng> get() = _locationLiveData

    fun updateLocation(location: LatLng) {
        _locationLiveData.value = location
    }
}