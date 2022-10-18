package com.example.jetpackapi

import com.example.jetpackapi.model.Apps
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//interface AppsInterface {
////    @GET("api/v2/in/apps/top-free/10/apps.json")
//    @GET("/apps.json")
//    suspend fun getApps():List<Apps>
//
//    companion object{
//        var apiService:AppsInterface?=null
//        fun getInstace():AppsInterface{
//            if (apiService == null){
////                apiService = Retrofit.Builder().baseUrl("https://rss.applemarketingtools.com/")
////                    .addConverterFactory(GsonConverterFactory.create()).build().create(AppsInterface::class.java)
//                apiService = Retrofit.Builder().baseUrl("https://rss.applemarketingtools.com/api/v2/in/apps/top-free/10")
//                    .addConverterFactory(GsonConverterFactory.create()).build().create(AppsInterface::class.java)
//            }
//            return apiService!!
//        }
//
//    }
//
//}