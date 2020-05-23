package com.example.hasproject.data.model.signin


import com.google.gson.annotations.SerializedName

data class ForProTabs(
    @SerializedName("items")
    val items: List<Item> = listOf(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Boolean = false
) {
    data class Item(
        @SerializedName("count_product")
        val countProduct: Int = 0,
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("image")
        val image: String = "",
        @SerializedName("sub_categories")
        val subCategories: List<Any> = listOf(),
        @SerializedName("title")
        val title: String = ""
    )
}