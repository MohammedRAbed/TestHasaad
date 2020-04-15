package com.example.hasproject

import android.content.Context
import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_ad_to_cart_dialog.*
import kotlinx.android.synthetic.main.activity_ad_to_cart_dialog.view.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_order_note.view.*
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {

    class RelatedFoodClass()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)




        go_from_details_to_cart.setOnClickListener {
            var intintForGoFromDetailsToCart = Intent(this , Cart::class.java)
            startActivity(intintForGoFromDetailsToCart)
        }

        back_from_detail_to_home.setOnClickListener {
            finish()
        }

        val sharedPreferences2 = getSharedPreferences("SP_Info", Context.MODE_PRIVATE)

        add_to_cart_btn.setOnClickListener {


            val price =  p_price.text.toString().trim()
            val p_name = product_name.text.toString().trim()
            val editor = sharedPreferences2.edit()
            editor.putString("NAME",p_name)
            editor.putString("PRICE",price)
            editor.apply()



            var firstDialogView = LayoutInflater.from(this).inflate(R.layout.activity_ad_to_cart_dialog,null)
            var firstBuilder = AlertDialog.Builder(this)
                .setView(firstDialogView)
            var firstAlertDialog = firstBuilder.show()



            val sharedPreferences = getSharedPreferences("SP_Info", Context.MODE_PRIVATE)

            firstDialogView.confirm_add_cart.setOnClickListener {


                val many = firstDialogView.et_many.text.toString().trim()
                val des = firstDialogView.et_des.text.toString().trim()
                val editor = sharedPreferences.edit()
                editor.putString("MANY",many)
                editor.putString("DES",des)
                editor.apply()

                val intentForGetCartt = Intent(this,Cart::class.java)
                startActivity(intentForGetCartt)
            }
            firstDialogView.x_dismiss.setOnClickListener {
                firstAlertDialog.dismiss()
            }

            firstAlertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent)




        }






        val recyclerViewForRelatedFood: RecyclerView = findViewById(R.id.recyclerView_for_related_food)
        recyclerViewForRelatedFood.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)

        val relattedFood = ArrayList<RelatedFoodClass>()

        relattedFood.add(RelatedFoodClass())
        relattedFood.add(RelatedFoodClass())
        relattedFood.add(RelatedFoodClass())
        relattedFood.add(RelatedFoodClass())

        val myAdapterForRelated = CoustumAdapterForRelatedFood(relattedFood)
        recyclerViewForRelatedFood.adapter = myAdapterForRelated
    }




    class CoustumAdapterForRelatedFood(val related_list :ArrayList<RelatedFoodClass>):RecyclerView.Adapter<CoustumAdapterForRelatedFood.myRelatedFoodHolder>(){
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myRelatedFoodHolder {
            var g = LayoutInflater.from(p0?.context).inflate(R.layout.related_food_list,p0,false)
            return myRelatedFoodHolder(g)
        }

        override fun getItemCount(): Int {
            return related_list.size
        }

        override fun onBindViewHolder(p0: myRelatedFoodHolder, p1: Int) {
            val related :RelatedFoodClass = related_list[p1]
        }


        class myRelatedFoodHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            var theImageForRelated = itemView.findViewById(R.id.image_related) as ImageView
            var theNameOfOneRelated = itemView.findViewById(R.id.name_related) as TextView
            var theTypeOfRelated = itemView.findViewById(R.id.type_related) as TextView
            var thePriceOfRelated = itemView.findViewById(R.id.price_related) as TextView
        }

    }

}
