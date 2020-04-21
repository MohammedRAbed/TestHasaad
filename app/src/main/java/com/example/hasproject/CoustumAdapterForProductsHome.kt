package com.example.hasproject

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hasproject.data.model.signin.ForHome
import com.example.hasproject.passData.PassProData
import kotlin.math.round

class CoustumAdapterForProductsHome(val context: Context) :RecyclerView.Adapter<CoustumAdapterForProductsHome.MyViewHolder>() {

    var home_product_list_food : List<ForHome.Items.Product> = listOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.favourite_home,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return home_product_list_food.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        //title
        p0.myText.text = home_product_list_food.get(p1).title
        //price
        p0.myPrice.text = "${home_product_list_food.get(p1).units.get(0).pivot.price.toDouble()} SR"
        //image
        Glide.with(context).load(home_product_list_food.get(p1).image)
            .apply(RequestOptions().centerCrop())
            .into(p0.myImage)

        p0.myImage.setOnClickListener{
            val intent = Intent(context,ProductDetails::class.java)
            val proData = PassProData(p0.myText.text.toString(),p0.myPrice.text.toString(),home_product_list_food.get(p1).units.get(0).title)
            intent.putExtra("ProData" , proData)
            context.startActivity(intent)
        }
    }

    fun setProductList(list: List<ForHome.Items.Product>) {
        this.home_product_list_food = list
        notifyDataSetChanged()
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myText : TextView
        var myImage : ImageView
        var myPrice : TextView

        init {
            myText = itemView.findViewById(R.id.my_text) as TextView
            myImage = itemView.findViewById(R.id.my_image) as ImageView
            myPrice = itemView.findViewById(R.id.my_price) as TextView

        }
    }
}