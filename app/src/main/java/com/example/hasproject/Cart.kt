package com.example.hasproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_ad_to_cart_dialog.view.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_order_note.*
import kotlinx.android.synthetic.main.activity_order_note.view.*
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.android.synthetic.main.cart_list.*

class Cart : AppCompatActivity() {

    class CartClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)







        check_cart.setOnClickListener {
            var mDialogView2 = LayoutInflater.from(this).inflate(R.layout.activity_order_note,null)
            var mBuilder2 = AlertDialog.Builder(this)
                .setView(mDialogView2)

            var mAlertDialog2 = mBuilder2.show()


            mDialogView2.done_note.setOnClickListener {
                val intentForGoToCheck = Intent(this , Check::class.java)
                startActivity(intentForGoToCheck)
            }

            mDialogView2.x_dismiss2.setOnClickListener {
                mAlertDialog2.dismiss()
            }

            mAlertDialog2.getWindow().setBackgroundDrawableResource(android.R.color.transparent)

        }





        back_from_cart_to_home.setOnClickListener {
           finish()
        }




        val recyclerViewForCart: RecyclerView = findViewById(R.id.recyclerView_for_cart)
        recyclerViewForCart.layoutManager = LinearLayoutManager(this)

        val cartFood = ArrayList<CartClass>()

        cartFood.add(CartClass())
        cartFood.add(CartClass())
        cartFood.add(CartClass())
        cartFood.add(CartClass())

        val myAdapterForCart = Cart.CoustumAdapterForCart(cartFood,this)
        recyclerViewForCart.adapter = myAdapterForCart
    }




    class CoustumAdapterForCart(val cartt_list :ArrayList<CartClass>,var context: Context):RecyclerView.Adapter<CoustumAdapterForCart.myCartHolder>(){
/*
        val sharedPreferences = getSharedPreferences("SP_Info", Context.MODE_PRIVATE)

        val many = sharedPreferences.getString("MANY","")
        many_x_items_cart.text = "$many"

*/
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myCartHolder {
            var z = LayoutInflater.from(p0?.context).inflate(R.layout.cart_list,p0,false)
            return myCartHolder(z)
        }

        override fun getItemCount(): Int {
            return cartt_list.size
        }

        override fun onBindViewHolder(p0: myCartHolder, p1: Int) {
            val related : Cart.CartClass = cartt_list[p1]
        }

         inner class myCartHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            var theImageForCart :ImageView
            var theNameOfCart:TextView
            var theManyOfCart :TextView
            var thePriceOfCart :TextView
            var theWeightOfCart :TextView


            init {
                theImageForCart = itemView.findViewById(R.id.image_cart) as ImageView
                 theNameOfCart = itemView.findViewById(R.id.name_cart) as TextView
                 theManyOfCart = itemView.findViewById(R.id.many_x_items_cart) as TextView
                 thePriceOfCart = itemView.findViewById(R.id.price_cart) as TextView
                 theWeightOfCart = itemView.findViewById(R.id.description_cart) as TextView

                val sharedPreferences = context.getSharedPreferences("SP_Info", Context.MODE_PRIVATE)

                val many = sharedPreferences.getString("MANY","1")
                theManyOfCart.text = "$many"

            }
        }


    }




}
