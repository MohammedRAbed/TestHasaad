package com.example.hasproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.categories_list.*
import kotlin.contracts.contract

class Categories : AppCompatActivity() {

    class CategoriesClass()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)


        back_from_categories_to_home.setOnClickListener {
            finish()
        }
        from_categories_to_cart.setOnClickListener {
            var intintForGoToCart = Intent(this , Cart::class.java)
            startActivity(intintForGoToCart)
        }




        val recyclerViewForCategories: RecyclerView = findViewById(R.id.recyclerView_for_categories)
        recyclerViewForCategories.layoutManager = LinearLayoutManager(this)

        val categoriess = ArrayList<CategoriesClass>()

        categoriess.add(CategoriesClass())
        categoriess.add(CategoriesClass())
        categoriess.add(CategoriesClass())
        categoriess.add(CategoriesClass())
        categoriess.add(CategoriesClass())

        val myAdapterForCategories = CoustumAdapterForCategories(categoriess)
        recyclerViewForCategories.adapter = myAdapterForCategories



    }


    class CoustumAdapterForCategories(val food_list :ArrayList<CategoriesClass>) : RecyclerView.Adapter<CoustumAdapterForCategories.MyHCategoriesHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHCategoriesHolder {
            var a = LayoutInflater.from(p0?.context).inflate(R.layout.categories_list,p0,false)
            return MyHCategoriesHolder(a)
        }

        override fun getItemCount(): Int {
            return food_list.size
        }

        override fun onBindViewHolder(p0: CoustumAdapterForCategories.MyHCategoriesHolder, p1: Int) {
            val categories_food:CategoriesClass = food_list[p1]
        }



        class MyHCategoriesHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
            var first_categories_img :ImageView
            var second_categories_img:ImageView
            var type_food_text :TextView
            var no_items_text :TextView
            var no_sr_text:TextView

            init{
                first_categories_img = itemView.findViewById(R.id.first_categories_list_img) as ImageView
                 second_categories_img =itemView.findViewById(R.id.second_categories_list_img) as ImageView
                 type_food_text = itemView.findViewById(R.id.type_food) as TextView
                 no_items_text =itemView.findViewById(R.id.no_items) as TextView
                 no_sr_text = itemView.findViewById(R.id.no_sr) as TextView


            }

        }

    }


}
