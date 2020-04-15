package com.example.hasproject


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.hasproject.data.model.signin.ForHome
import com.example.hasproject.data.remote.APIUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

class HomeFragment : Fragment() {


    //class HomeFavouriteClass()

    //categories
    lateinit var recyclerForCat : RecyclerView
    lateinit var catAdapter : CoustumAdapterForHomeCategories

    //products
    lateinit var recyclerForPro : RecyclerView
    lateinit var proAdapter : CoustumAdapterForProductsHome

    //offer product
    lateinit var recyclerForOff : RecyclerView
    lateinit var offAdapter : CoustumAdapterForOffersHome


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewToHome = inflater.inflate(R.layout.home, container, false)

        //categories
        recyclerForCat = viewToHome.findViewById(R.id.recyclerView_for_home_categories)
        catAdapter = CoustumAdapterForHomeCategories(context!!)
        recyclerForCat.layoutManager = LinearLayoutManager(context!!,LinearLayout.HORIZONTAL,false)
        recyclerForCat.adapter = catAdapter

        //products
        recyclerForPro = viewToHome.findViewById(R.id.recycler_for_home_favourite)
        proAdapter = CoustumAdapterForProductsHome(context!!)
        recyclerForPro.layoutManager = LinearLayoutManager(context!!,LinearLayout.HORIZONTAL,false)
        recyclerForPro.adapter = proAdapter

        //offer product
        recyclerForOff = viewToHome.findViewById(R.id.home_offer_recyclerview)
        offAdapter = CoustumAdapterForOffersHome(context!!)
        recyclerForOff.layoutManager = LinearLayoutManager(context!!, LinearLayout.HORIZONTAL,false)
        recyclerForOff.adapter = offAdapter



        val mAPIInterface = APIUtils().getAPIInterface()
        val map: MutableMap<String, String> = HashMap()
        map["Accept"] = "application/json"
        map["Accept-Language"] = "en"

        mAPIInterface?.home(map)!!.enqueue(object : Callback<ForHome> {
            override fun onFailure(call: Call<ForHome>?, t: Throwable?) {
                Toast.makeText(context, "Error !", Toast.LENGTH_SHORT).show()
                println("Error")
            }

            override fun onResponse(call: Call<ForHome>?, response: Response<ForHome>?) {
                if (response?.body() != null) {
                    Toast.makeText(context, "Response is not empty !", Toast.LENGTH_SHORT).show()
                    catAdapter.setMovieListItems(response.body().items.categories)
                    proAdapter.setProductList(response.body().items.products)
                    offAdapter.setOfferList(response.body().items.offerProducts)
                }
                if(response?.body() == null){
                    Toast.makeText(context, "Response is empty !", Toast.LENGTH_SHORT).show()
                    println("response.code ::: " + response?.code())
                }

            }

        })


        val button: Button = viewToHome.findViewById(R.id.to_categories)
        button.setOnClickListener {

            val intintForGetCategories = Intent(context, Categories::class.java)
            startActivity(intintForGetCategories)

        }

       val cartHome: Button = viewToHome.findViewById(R.id.home_cart)
        cartHome.setOnClickListener {
            val intentForGetCartHome = Intent(context, Cart::class.java)
            startActivity(intentForGetCartHome)
        }

        // Inflate the layout for this fragment
        return viewToHome
    }

}
