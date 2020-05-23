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

class CoustumAdapterForHomeCategories(
    val context: Context
) : RecyclerView.Adapter<CoustumAdapterForHomeCategories.myHomeCategoriesHolder>() {

    var home_categories_list_food: List<ForHome.Items.Category> = listOf()

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): CoustumAdapterForHomeCategories.myHomeCategoriesHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.home_categories_list, p0, false)
        return myHomeCategoriesHolder(view)
    }

    override fun getItemCount(): Int {
        return home_categories_list_food.size
    }


    override fun onBindViewHolder(
        holder: CoustumAdapterForHomeCategories.myHomeCategoriesHolder,
        p: Int
    ) {
        //title
        holder.theNameOfHomeCategories.text = home_categories_list_food.get(p).title
        //image
        Glide.with(context).load(home_categories_list_food.get(p).image)
            .apply(RequestOptions().centerCrop())
            .into(holder.theImageOfHomeCategories)

        holder.theImageOfHomeCategories.setOnClickListener{
            val intent : Intent = Intent(context, Categories::class.java)
            context.startActivity(intent)
        }
    }

    fun setMovieListItems(home_categories_list_food: List<ForHome.Items.Category>) {
        this.home_categories_list_food = home_categories_list_food
        notifyDataSetChanged()
    }


    inner class myHomeCategoriesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var theImageOfHomeCategories: ImageView
        var theNameOfHomeCategories: TextView
        var theNumberOfItemsOfHomeCategories: TextView
        var thepriceOfItemsOfHomeCategories: TextView

        init {

            theImageOfHomeCategories =
                itemView.findViewById(R.id.image_for_home_categories) as ImageView
            theNameOfHomeCategories =
                itemView.findViewById(R.id.name_for_home_categories) as TextView
            theNumberOfItemsOfHomeCategories =
                itemView.findViewById(R.id.more_home_items) as TextView
            thepriceOfItemsOfHomeCategories =
                itemView.findViewById(R.id.price_home_items) as TextView

        }
    }
}