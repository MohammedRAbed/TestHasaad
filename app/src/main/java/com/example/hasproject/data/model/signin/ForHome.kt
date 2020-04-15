package com.example.hasproject.data.model.signin


import com.google.gson.annotations.SerializedName

data class ForHome(
    @SerializedName("items")
    val items: Items = Items(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Boolean = false
) {
    data class Items(
        @SerializedName("categories")
        val categories: List<Category> = listOf(),
        @SerializedName("offer_products")
        val offerProducts: List<OfferProduct> = listOf(),
        @SerializedName("products")
        val products: List<Product> = listOf()
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

        data class OfferProduct(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("image")
            val image: String = "",
            @SerializedName("is_offer")
            val isOffer: String = "",
            @SerializedName("price")
            val price: String = "",
            @SerializedName("price_after_discount")
            val priceAfterDiscount: Any = Any(),
            @SerializedName("sub_category")
            val subCategory: SubCategory = SubCategory(),
            @SerializedName("sub_category_id")
            val subCategoryId: String = "",
            @SerializedName("title")
            val title: String = "",
            @SerializedName("type")
            val type: String = ""
        ) {
            data class SubCategory(
                @SerializedName("category_id")
                val categoryId: String = "",
                @SerializedName("id")
                val id: Int = 0,
                @SerializedName("title")
                val title: String = ""
            )
        }

        data class Product(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("image")
            val image: String = "",
            @SerializedName("is_offer")
            val isOffer: String = "",
            @SerializedName("price")
            val price: String = "",
            @SerializedName("price_after_discount")
            val priceAfterDiscount: Any = Any(),
            @SerializedName("sub_category")
            val subCategory: SubCategory = SubCategory(),
            @SerializedName("sub_category_id")
            val subCategoryId: String = "",
            @SerializedName("title")
            val title: String = "",
            @SerializedName("type")
            val type: String = ""
        ) {
            data class SubCategory(
                @SerializedName("category_id")
                val categoryId: String = "",
                @SerializedName("id")
                val id: Int = 0,
                @SerializedName("title")
                val title: String = ""
            )
        }
    }
}