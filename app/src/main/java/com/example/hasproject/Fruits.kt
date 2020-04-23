package com.example.hasproject

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_fish_food.view.*


class Fruits : Fragment() {

    class ProductFoodClass()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fish_food, container, false)

        val recyclerForProFood : RecyclerView = view.recycler_pro_food
        recyclerForProFood.layoutManager = LinearLayoutManager(context)
        val proFood = ArrayList<ProductFoodClass>()

        proFood.add(ProductFoodClass())
        proFood.add(ProductFoodClass())
        proFood.add(ProductFoodClass())
        proFood.add(ProductFoodClass())
        proFood.add(ProductFoodClass())

        val proFoodAdapter = FruitsAdapter(proFood,context!!)
        recyclerForProFood.adapter = proFoodAdapter



        return view
    }


    class FruitsAdapter(val pro_food_list: List<ProductFoodClass>,val context: Context) : RecyclerView.Adapter<FruitsAdapter.MyViewHolder>() {



        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
            val createView : View  = LayoutInflater.from(context).inflate(R.layout.product_food_list, p0 , false)
            return MyViewHolder(createView)
        }

        override fun getItemCount(): Int {
            return pro_food_list.size
        }

        override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        }


        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var theNameOfPro: TextView
            var theTypeOfPro: TextView
            var theImageOfPro: ImageView
            var thePriceOfPro: TextView

            init {
                theNameOfPro = itemView.findViewById(R.id.name_pro)
                theTypeOfPro = itemView.findViewById(R.id.type_pro)
                thePriceOfPro = itemView.findViewById(R.id.price_pro)
                theImageOfPro = itemView.findViewById(R.id.image_pro)
            }
        }

    }
}
