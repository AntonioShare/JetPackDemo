package com.amy.jetpackdemo.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewMode : ViewModel() {
    private var timingLiveData = MutableLiveData<Long>()
    val _timingLiveData: LiveData<Long>
        get() = timingLiveData
}