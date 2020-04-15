package com.example.hasproject.data.remote



class APIUtils {

    val BASE_URL  = "http://hassadsa.com/api/"

    fun getAPIInterface () : APIInterface? {
        return APIClient.getClient(BASE_URL)!!.create(APIInterface::class.java)
    }
}