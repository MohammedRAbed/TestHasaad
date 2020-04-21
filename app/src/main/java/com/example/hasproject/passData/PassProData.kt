package com.example.hasproject.passData

import java.io.Serializable

class PassProData(name:String , price:String ,title:String) : Serializable {
    internal var name:String
    internal var price : String
    internal var title : String
    init {
        this.name = name
        this.price = price
        this.title = title
    }
}




