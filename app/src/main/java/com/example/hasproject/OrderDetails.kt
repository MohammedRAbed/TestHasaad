package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_order_details.*

class OrderDetails : AppCompatActivity() {

    class OneOrderClass()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        back_from_order_details_to_home.setOnClickListener {
            finish()
        }
        record_order.setOnClickListener {
            finish()
        }



        val recyclerViewForOneOrder: RecyclerView = findViewById(R.id.recyclerView_for_cart)
        recyclerViewForOneOrder.layoutManager = LinearLayoutManager(this)

        val orderr = ArrayList<OneOrderClass>()

        orderr.add(OneOrderClass())
        orderr.add(OneOrderClass())
        orderr.add(OneOrderClass())
        orderr.add(OneOrderClass())
        orderr.add(OneOrderClass())
        orderr.add(OneOrderClass())
        orderr.add(OneOrderClass())

        val myAdapterForOneOrder = CoustumAdapterForOneOrder(orderr)
        recyclerViewForOneOrder.adapter = myAdapterForOneOrder

    }




    class CoustumAdapterForOneOrder(val one_order_food_list :ArrayList<OneOrderClass>):RecyclerView.Adapter<CoustumAdapterForOneOrder.myOneOrderHolder>(){
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myOneOrderHolder {
            val e = LayoutInflater.from(p0?.context).inflate(R.layout.one_order_list,p0,false)
            return myOneOrderHolder(e)
        }

        override fun getItemCount(): Int {
            return one_order_food_list.size
        }

        override fun onBindViewHolder(p0: CoustumAdapterForOneOrder.myOneOrderHolder, p1: Int) {
            val one_order_food :OneOrderClass = one_order_food_list[p1]
        }



        class myOneOrderHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
            var theImageOfOneOrder =itemView.findViewById(R.id.image_cart) as ImageView
            var theNameOfOneOrder = itemView.findViewById(R.id.name_cart) as TextView
            var theNumberOfXOfOneOrder = itemView.findViewById(R.id.many_x_items_cart) as TextView
            var thePriceOfOneOrder = itemView.findViewById(R.id.price_cart) as TextView
            var theDiscription = itemView.findViewById(R.id.description_cart) as TextView
        }

    }

}
