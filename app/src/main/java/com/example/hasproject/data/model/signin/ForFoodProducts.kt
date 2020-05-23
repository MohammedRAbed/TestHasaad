package com.example.hasproject.data.model.signin


import com.google.gson.annotations.SerializedName

data class ForFoodProducts(
    @SerializedName("items")
    val items: List<Item> = listOf(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Boolean = false
) {
    data class Item(
        @SerializedName("category")
        val category: Category = Category(),
        @SerializedName("category_id")
        val categoryId: String = "",
        @SerializedName("details")
        val details: Any = Any(),
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("image")
        val image: String = "",
        @SerializedName("is_offer")
        val isOffer: String = "",
        @SerializedName("price_after_discount")
        val priceAfterDiscount: Any = Any(),
        @SerializedName("title")
        val title: String = "",
        @SerializedName("units")
        val units: List<Unit> = listOf()
    ) {
        data class Category(
            @SerializedName("count_product")
            val countProduct: Int = 0,
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("image")
            val image: String = "",
            @SerializedName("title")
            val title: String = ""
        )

        data class Unit(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("pivot")
            val pivot: Pivot = Pivot(),
            @SerializedName("title")
            val title: String = ""
        ) {
            data class Pivot(
                @SerializedName("price")
                val price: String = "",
                @SerializedName("product_id")
                val productId: String = "",
                @SerializedName("unit_id")
                val unitId: String = ""
            )
        }
    }
}