package com.example.jetpackapi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicalling.interfaces.ApiInterface
//import com.example.apicalling.models.Model
import com.example.jetpackapi.model.Apps
import kotlinx.coroutines.launch

class AppsViewModel:ViewModel() {
    var appsListResponse:List<com.example.jetpackapi.model.Result> by mutableStateOf(listOf())
    var errorMsg:String by mutableStateOf("")

    fun getAppsList(){
        viewModelScope.launch {
            val apiService = ApiInterface.getInstace()
            try {
                val appsList = apiService.getData()
                appsListResponse = appsList.feed.results
            }
            catch (e:Exception){
                errorMsg = e.message.toString()
            }
        }
    }
}