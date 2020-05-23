package com.example.hasproject


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hasproject.data.model.signin.ForProTabs
import com.example.hasproject.data.remote.APIUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewToProduct = inflater.inflate( R.layout.products, container, false)

        var vPager : ViewPager = viewToProduct.findViewById(R.id.viewPager)
        var vPadapter : MainHome.MyPagerAdapter = MainHome.MyPagerAdapter(fragmentManager!!)
        vPager.adapter = vPadapter

        val mAPIInterface = APIUtils().getAPIInterface()
        val map: MutableMap<String, String> = HashMap()
        map["Accept"] = "application/json"
        map["Accept-Language"] = "ar"

        mAPIInterface?.proTabs(map)!!.enqueue(object : Callback<ForProTabs> {
            override fun onFailure(call: Call<ForProTabs>?, t: Throwable?) {
                Toast.makeText(context, "Tabs Failed", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<ForProTabs>?, response: Response<ForProTabs>?) {
                val intent = Intent(context, FishFood::class.java)
                if (response?.body() == null) {
                    Toast.makeText(context, "Tabs NULL", Toast.LENGTH_SHORT).show()
                } else {
                    vPadapter.setData(response.body().items)
                }
            }
        })
        return viewToProduct
    }




}
