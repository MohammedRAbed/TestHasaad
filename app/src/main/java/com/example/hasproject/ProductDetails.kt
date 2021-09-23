package com.example.hasproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.hasproject.passData.PassProData
import com.example.hasproject.saveData.CartClass
import com.example.hasproject.saveData.cartList
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_ad_to_cart_dialog.*
import kotlinx.android.synthetic.main.activity_ad_to_cart_dialog.view.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_order_note.view.*
import kotlinx.android.synthetic.main.activity_product_details.*
import java.util.*
import kotlin.collections.ArrayList

class ProductDetails : AppCompatActivity() {

    class RelatedFoodClass()


    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val nameProD: TextView = findViewById(R.id.product_name)
        val offerProD: TextView = findViewById(R.id.offer_p)
        val priceProD: TextView = findViewById(R.id.price_p)
        val imgOffProD: ImageView = findViewById(R.id.off_img)
        val kgPro: TextView = findViewById(R.id.kg)
        val itemsPro: TextView = findViewById(R.id.itemss)
        val pacPro: TextView = findViewById(R.id.packagee)


        val proData: PassProData? = intent.getSerializableExtra("ProData") as? PassProData

        nameProD.text = proData?.name

        if (proData?.offer == "") {
            offerProD.text = proData.price
            priceProD.text = ""
            imgOffProD.visibility = View.INVISIBLE
        } else {
            offerProD.text = proData?.offer
            priceProD.text = proData?.price

        }

        kgPro.text = proData?.title
        itemsPro.text = proData?.title
        pacPro.text = proData?.title

        var isTypeOn = false
        kgPro.setOnClickListener {
            val type = kgPro.text.toString().trim()
            kgPro.setTextColor(Color.parseColor("#EB1D1D"))
            itemsPro.setTextColor(Color.parseColor("#898989"))
            pacPro.setTextColor(Color.parseColor("#898989"))
            isTypeOn = true
        }
        itemsPro.setOnClickListener {
            val type = kgPro.text.toString().trim()
            kgPro.setTextColor(Color.parseColor("#898989"))
            itemsPro.setTextColor(Color.parseColor("#EB1D1D"))
            pacPro.setTextColor(Color.parseColor("#898989"))
            isTypeOn = true
        }
        pacPro.setOnClickListener {
            val type = kgPro.text.toString().trim()
            kgPro.setTextColor(Color.parseColor("#898989"))
            itemsPro.setTextColor(Color.parseColor("#898989"))
            pacPro.setTextColor(Color.parseColor("#EB1D1D"))
            isTypeOn = true
        }



        go_from_details_to_cart.setOnClickListener {
            val intintForGoFromDetailsToCart = Intent(this, Cart::class.java)
            startActivity(intintForGoFromDetailsToCart)
        }

        back_from_detail_to_home.setOnClickListener {
            finish()
        }


        add_to_cart_btn.setOnClickListener {
            if(isTypeOn == true) {
                var counter = 0

                if (counter == cartList.size) {
                    addToCart()
                } else {
                    if (Arrays.asList(cartList.get(0).name)!!.contains(product_name.text.toString())) {

                        Toast.makeText(
                            this,
                            "This Product is already added to the cart",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        addToCart()
                    }
                }
            }
            else {
                Toast.makeText(this, "You forgot to choose the product type" , Toast.LENGTH_SHORT).show()
            }
        }


        val recyclerViewForRelatedFood: RecyclerView =
            findViewById(R.id.recyclerView_for_related_food)
        recyclerViewForRelatedFood.layoutManager =
            LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)

        val relattedFood = ArrayList<RelatedFoodClass>()

        relattedFood.add(RelatedFoodClass())
        relattedFood.add(RelatedFoodClass())
        relattedFood.add(RelatedFoodClass())
        relattedFood.add(RelatedFoodClass())

        val myAdapterForRelated = CoustumAdapterForRelatedFood(relattedFood)
        recyclerViewForRelatedFood.adapter = myAdapterForRelated
    }


    class CoustumAdapterForRelatedFood(val related_list: ArrayList<RelatedFoodClass>) :
        RecyclerView.Adapter<CoustumAdapterForRelatedFood.myRelatedFoodHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myRelatedFoodHolder {
            var g = LayoutInflater.from(p0?.context).inflate(R.layout.related_food_list, p0, false)
            return myRelatedFoodHolder(g)
        }

        override fun getItemCount(): Int {
            return related_list.size
        }

        override fun onBindViewHolder(p0: myRelatedFoodHolder, p1: Int) {
            val related: RelatedFoodClass = related_list[p1]
        }


        class myRelatedFoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var theImageForRelated = itemView.findViewById(R.id.image_related) as ImageView
            var theNameOfOneRelated = itemView.findViewById(R.id.name_related) as TextView
            var theTypeOfRelated = itemView.findViewById(R.id.type_related) as TextView
            var thePriceOfRelated = itemView.findViewById(R.id.price_related) as TextView
        }

    }


    fun addToCart() {

        val price = offer_p.text.toString().trim()
        val p_name = product_name.text.toString().trim()
        var type: String =""

        if (kg.currentTextColor == Color.parseColor("#EB1D1D")) {
            type = kg.text.toString().trim()
        }
        if (itemss.currentTextColor == Color.parseColor("#EB1D1D")) {
            type = itemss.text.toString().trim()
        }
        if (packagee.currentTextColor == Color.parseColor("#EB1D1D")) {
            type = packagee.text.toString().trim()
        }


        //For Dialog ..

        var firstDialogView =
            LayoutInflater.from(this).inflate(R.layout.activity_ad_to_cart_dialog, null)

        var firstBuilder = AlertDialog.Builder(this)
            .setView(firstDialogView)

        var firstAlertDialog = firstBuilder.show()

        firstDialogView.confirm_add_cart.setOnClickListener {
            val many = firstDialogView.et_many.text.toString().trim()
            val des = firstDialogView.et_des.text.toString().trim()


            val cartClass = CartClass(p_name, many, price, des, type)
            cartList.add(cartClass)

            val gson = Gson()
            val json = gson.toJson(cartList)

            val sp = getSharedPreferences("SP", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("KEY", json)
            editor.apply()


            val intentForGetCartt = Intent(this, Cart::class.java)
            startActivity(intentForGetCartt)
        }


        firstDialogView.x_dismiss.setOnClickListener {
            firstAlertDialog.dismiss()
        }

        firstAlertDialog.getWindow()!!.setBackgroundDrawableResource(android.R.color.transparent)

    }

}
