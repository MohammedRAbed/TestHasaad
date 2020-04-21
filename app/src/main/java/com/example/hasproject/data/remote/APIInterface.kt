package com.example.hasproject.data.remote

import com.example.hasproject.data.model.signin.ForHome
import com.example.hasproject.data.model.signin.ForLogIn
import retrofit2.Call
import retrofit2.http.*


interface APIInterface {
    //login
    @POST("user/login")
    @FormUrlEncoded
    fun loginUser(
        @HeaderMap accept_lan: MutableMap<String, String>,
        @Field("mobile") mobile: String,
        @Field("password") password: String
    ): Call<ForLogIn>

    //home
    @GET("getHomeData")
    fun home(
        @HeaderMap accept_home_cat: MutableMap<String, String>
    ): Call<ForHome>


}
