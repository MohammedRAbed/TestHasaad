package com.example.hasproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hasproject.data.model.signin.ForFoodProducts
import com.example.hasproject.data.model.signin.ForHome
import com.example.hasproject.data.model.signin.ForProTabs
import com.example.hasproject.data.remote.APIUtils
import com.example.hasproject.passData.Communicator
import com.example.hasproject.passData.PassProData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FishFood : Fragment(){

    lateinit var recyclerFood: RecyclerView
    lateinit var adapterFood: ProFoodAdapter

    private var id : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        id = arguments?.getInt("id")
        println(id)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fish_food, container, false)
        recyclerFood = view.findViewById(R.id.recycler_pro_food)
        adapterFood = ProFoodAdapter(context!!)
        recyclerFood.layoutManager = LinearLayoutManager(context)
        recyclerFood.adapter = adapterFood

        val mAPIInterface = APIUtils().getAPIInterface()
        val map: MutableMap<String, String> = HashMap()
        map["Accept"] = "application/json"
        map["Accept-Language"] = "en"



        mAPIInterface?.productsOfCategory(map,id!!.toInt())!!.enqueue(object : Callback<ForFoodProducts> {
            override fun onFailure(call: Call<ForFoodProducts>?, t: Throwable?) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(
                call: Call<ForFoodProducts>?,
                response: Response<ForFoodProducts>?
            ) {
                if (response?.body() == null) {
                    Toast.makeText(context, "NULL", Toast.LENGTH_SHORT).show()
                } else {
                    adapterFood.setFishFoodList(response.body().items)
                }
            }

        })

        return view
    }



    class ProFoodAdapter(val context: Context) :
        RecyclerView.Adapter<ProFoodAdapter.MyViewHolder>() {

        var pro_food_list: List<ForFoodProducts.Item> = listOf()

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
            val createView: View =
                LayoutInflater.from(context).inflate(R.layout.product_food_list, p0, false)
            return MyViewHolder(createView)
        }

        override fun getItemCount(): Int {
            return pro_food_list.size
        }

        override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
            //title
            p0.theNameOfPro.text = pro_food_list.get(p1).title
            //image
            Glide.with(context).load(pro_food_list.get(p1).image)
                .apply(RequestOptions().centerCrop())
                .into(p0.theImageOfPro)
            //type
            p0.theTypeOfPro.text = pro_food_list.get(p1).category.title
            //price&offer
            if (pro_food_list.get(p1).priceAfterDiscount == null) {
                p0.theOfferImage.visibility = View.INVISIBLE
                p0.thePriceOfPro.text = ""
                p0.theOfferOfPro.text = pro_food_list.get(p1).units.get(0).pivot.price
            } else {
                p0.thePriceOfPro.text = pro_food_list.get(p1).units.get(0).pivot.price
                p0.theOfferOfPro.text = pro_food_list.get(p1).priceAfterDiscount.toString()
            }

            p0.theCardOfPro.setOnClickListener {
                val intent = Intent(context, ProductDetails::class.java)
                val proData = PassProData(
                    p0.theNameOfPro.text.toString(),
                    pro_food_list.get(p1).units.get(0).title,
                    p0.thePriceOfPro.text.toString() + " SR",
                    p0.theOfferOfPro.text.toString() + " SR"
                )
                intent.putExtra("ProData", proData)
                context.startActivity(intent)
            }
        }

        fun setFishFoodList(pro_food: List<ForFoodProducts.Item>) {
            this.pro_food_list = pro_food
            notifyDataSetChanged()
        }


        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var theCardOfPro: CardView
            var theNameOfPro: TextView
            var theTypeOfPro: TextView
            var theImageOfPro: ImageView
            var thePriceOfPro: TextView
            var theOfferOfPro: TextView
            var theOfferImage: ImageView

            init {
                theNameOfPro = itemView.findViewById(R.id.name_pro)
                theTypeOfPro = itemView.findViewById(R.id.type_pro)
                thePriceOfPro = itemView.findViewById(R.id.price_pro)
                theImageOfPro = itemView.findViewById(R.id.image_pro)
                theOfferOfPro = itemView.findViewById(R.id.offer_pro)
                theOfferImage = itemView.findViewById(R.id.offer_img)
                theCardOfPro = itemView.findViewById(R.id.pr_food_card)
            }
        }

    }

    companion object {
        fun newInstance(id:Int) : FishFood {
            val frag1 = FishFood()
            val args = Bundle()
            args.putInt("id" , id)
            frag1.arguments = args
            return frag1
        }
    }


}
