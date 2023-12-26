package com.example.flowpratice.data.api

import com.example.flowpratice.data.dataholder.WallpaperData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("api/?key=41400369-6f706ba6c658a04001bc4aca5")
    fun gettingWallpapers(@Query("q") pic:String, @Query("image_type") type:String) : Call<WallpaperData>

}