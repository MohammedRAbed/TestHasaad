package com.example.hasproject

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hasproject.data.model.signin.ForHome

class CoustumAdapterForOffersHome(val context: Context) : RecyclerView.Adapter<CoustumAdapterForOffersHome.MyViewHolder>() {

    var home_offers_list : List<ForHome.Items.OfferProduct> = listOf()

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): MyViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.home_orders_list , p0 , false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return home_offers_list.size
    }

    override fun onBindViewHolder(p0: CoustumAdapterForOffersHome.MyViewHolder, p1: Int) {
        p0.theNameOfOrder.text = home_offers_list.get(p1).title
        Glide.with(context).load(home_offers_list.get(p1).image)
            .apply(RequestOptions().centerCrop())
            .into(p0.theImageOfOrder)
    }

    fun setOfferList(list: List<ForHome.Items.OfferProduct>) {
        this.home_offers_list = list
        notifyDataSetChanged()
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var theNameOfOrder : TextView
        var theImageOfOrder : ImageView
        var theBtnToBuy : Button

        init {
            theNameOfOrder = itemView.findViewById(R.id.home_order_name)
            theImageOfOrder = itemView.findViewById(R.id.home_order_image)
            theBtnToBuy = itemView.findViewById(R.id.buy_home_order)

            itemView.setOnClickListener {
                context.startActivity(Intent(context, ProductDetails::class.java))
            }
        }
    }

}