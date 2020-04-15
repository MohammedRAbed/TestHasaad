package com.example.hasproject.data.model.signin


import com.google.gson.annotations.SerializedName

data class ForLogIn(
    @SerializedName("items")
    val items: Items = Items(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Boolean = false
) {
    data class Items(
        @SerializedName("access_token")
        val accessToken: String = "",
        @SerializedName("city")
        val city: City = City(),
        @SerializedName("city_id")
        val cityId: String = "",
        @SerializedName("device_type")
        val deviceType: String = "",
        @SerializedName("email")
        val email: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("latitude")
        val latitude: String = "",
        @SerializedName("longitude")
        val longitude: String = "",
        @SerializedName("mobile")
        val mobile: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("profile_image")
        val profileImage: String = "",
        @SerializedName("sex")
        val sex: String = ""
    ) {
        data class City(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("title")
            val title: String = ""
        )
    }
}