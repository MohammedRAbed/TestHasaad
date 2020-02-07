package com.example.hasproject


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.home_categories_list.*
import kotlinx.android.synthetic.main.home_categories_list.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    class HomeCategoriesClass()
    class HomeFavouriteClass()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewToHome = inflater.inflate(R.layout.home, container, false)



        val button : Button = viewToHome.findViewById(R.id.to_categories)
        button.setOnClickListener {
            var intintForGetCategories = Intent(context , Categories::class.java)
            startActivity(intintForGetCategories)
        }


        val cartHome :Button = viewToHome.findViewById(R.id.home_cart)
        cartHome.setOnClickListener {
            var intentForGetCartHome = Intent(context, Cart::class.java)
            startActivity(intentForGetCartHome)
        }



        val recycler : RecyclerView = viewToHome.findViewById(R.id.recyclerView_for_home_categories)

        val recyclerViewForHomeCategories: RecyclerView = recycler
        recyclerViewForHomeCategories.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)

        val home_categories = ArrayList<HomeCategoriesClass>()

        home_categories.add(HomeCategoriesClass())
        home_categories.add(HomeCategoriesClass())
        home_categories.add(HomeCategoriesClass())
        home_categories.add(HomeCategoriesClass())

        val myAdapterForHomeCategories = CoustumAdapterForHomeCategories(home_categories,context!!)
        recyclerViewForHomeCategories.adapter = myAdapterForHomeCategories







        val recycler2:RecyclerView = viewToHome.findViewById(R.id.recycler_for_home_favourite)
        val recyclerForFavouriteHome:RecyclerView =recycler2
        recyclerForFavouriteHome.layoutManager = LinearLayoutManager(context,LinearLayout.HORIZONTAL,false)

        val home_favourite = ArrayList<HomeFavouriteClass>()

        home_favourite.add(HomeFavouriteClass())
        home_favourite.add(HomeFavouriteClass())
        home_favourite.add(HomeFavouriteClass())
        home_favourite.add(HomeFavouriteClass())
        home_favourite.add(HomeFavouriteClass())

        val myAdapterForFavouriteHome = CoustumAdapterForFavouriteHome(home_favourite)
        recyclerForFavouriteHome.adapter = myAdapterForFavouriteHome



        // Inflate the layout for this fragment
        return viewToHome
    }




     class CoustumAdapterForHomeCategories(val home_categories_list_food : ArrayList<HomeCategoriesClass>,val context: Context) :RecyclerView.Adapter<CoustumAdapterForHomeCategories.myHomeCategoriesHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CoustumAdapterForHomeCategories.myHomeCategoriesHolder {

            val c =LayoutInflater.from(p0?.context).inflate(R.layout.home_categories_list,p0,false)
            return myHomeCategoriesHolder(c)
        }

        override fun getItemCount(): Int {
            return home_categories_list_food.size
        }

        override fun onBindViewHolder(p0: CoustumAdapterForHomeCategories.myHomeCategoriesHolder, p1: Int) {
            val home_catrgories_food : HomeCategoriesClass = home_categories_list_food[p1]
        }



       inner class myHomeCategoriesHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            val intent:Intent? =null
            var theImageOfHomeCategories:ImageView
            var theNameOfHomeCategories :TextView
            var theNumberOfItemsOfHomeCategories:TextView
            var thepriceOfItemsOfHomeCategories :TextView

           init {
               theImageOfHomeCategories =itemView.findViewById(R.id.image_for_home_categories) as ImageView
                theNameOfHomeCategories =itemView.findViewById(R.id.name_for_home_categories) as TextView
                theNumberOfItemsOfHomeCategories =itemView.findViewById(R.id.more_home_items) as TextView
                thepriceOfItemsOfHomeCategories =itemView.findViewById(R.id.price_home_items) as TextView

               itemView.setOnClickListener {
                   context.startActivity(Intent(context,ProductDetails::class.java))
               }
           }
        }



    }

    class CoustumAdapterForFavouriteHome(val home_favourite_list_food :ArrayList<HomeFavouriteClass>) :RecyclerView.Adapter<CoustumAdapterForFavouriteHome.myFavouriteHomeHolder> () {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CoustumAdapterForFavouriteHome.myFavouriteHomeHolder {
            val k =LayoutInflater.from(p0?.context).inflate(R.layout.favourite_home,p0,false)
            return myFavouriteHomeHolder(k)        }

        override fun getItemCount(): Int {
            return home_favourite_list_food.size
        }

        override fun onBindViewHolder(p0: CoustumAdapterForFavouriteHome.myFavouriteHomeHolder, p1: Int) {
            val home_favourite_food : HomeFavouriteClass = home_favourite_list_food[p1]
        }

        class myFavouriteHomeHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

            var myText = itemView.findViewById(R.id.my_text) as TextView
            var myImage = itemView.findViewById(R.id.my_image) as ImageView

        }

    }



}
