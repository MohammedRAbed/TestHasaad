package com.example.hasproject.passData

import java.io.Serializable

class PassProData(name:String ,title:String , price:String , offer :String) : Serializable {
    internal var name : String
    internal var title : String
    internal var price : String
    internal var offer : String
    init {
        this.name = name
        this.title = title
        this.price = price
        this.offer = offer
    }
}




