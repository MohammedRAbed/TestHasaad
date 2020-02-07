package com.example.hasproject


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.favourit.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FavouritFragment : Fragment() {

    class FavouritesClass()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewToFavourite = inflater.inflate(R.layout.favourit, container, false)


        viewToFavourite.go_from_favourite_to_cart.setOnClickListener {
            var intintForGoFromFavouriteToCart = Intent(context , Cart::class.java)
            startActivity(intintForGoFromFavouriteToCart)
        }



        val recyclerViewForFavourite: RecyclerView = viewToFavourite.recyclerView_for_favourite
        recyclerViewForFavourite.layoutManager = LinearLayoutManager(context)

        val favouritess = ArrayList<FavouritesClass>()

        favouritess.add(FavouritesClass())
        favouritess.add(FavouritesClass())
        favouritess.add(FavouritesClass())
        favouritess.add(FavouritesClass())
        favouritess.add(FavouritesClass())

        val myAdapterForFavourites = CoustumAdapterForFavourites(favouritess,context!!)
        recyclerViewForFavourite.adapter = myAdapterForFavourites






        // Inflate the layout for this fragment
        return viewToFavourite
    }

    class CoustumAdapterForFavourites(val favourite_food_list: ArrayList<FavouritesClass>,val context: Context) :RecyclerView.Adapter<CoustumAdapterForFavourites.MyFavouriteHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CoustumAdapterForFavourites.MyFavouriteHolder {
            var b = LayoutInflater.from(p0?.context).inflate(R.layout.favourit_list,p0,false)
            return MyFavouriteHolder(b)
        }

        override fun getItemCount(): Int {
            return favourite_food_list.size
        }

        override fun onBindViewHolder(p0: CoustumAdapterForFavourites.MyFavouriteHolder, p1: Int) {
            val favourites_foods: FavouritesClass = favourite_food_list[p1]
        }

        inner class MyFavouriteHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
            val intent:Intent? =null
            var theNameOfFavourite:TextView
            var theTypeOfFavourite  :TextView
            var theImageOfFavourite :ImageView
            var thePriceOfFavourit  :TextView
            var thePerCentOfFavourite :TextView

            init {
                theNameOfFavourite =itemView.findViewById(R.id.name_related) as TextView
                 theTypeOfFavourite = itemView.findViewById(R.id.type_related) as TextView
                 theImageOfFavourite = itemView.findViewById(R.id.image_related) as ImageView
                 thePriceOfFavourit = itemView.findViewById(R.id.price_related) as TextView
                 thePerCentOfFavourite = itemView.findViewById(R.id.per_cent_favourite) as TextView

                itemView.setOnClickListener {
                    context.startActivity(Intent(context,ProductDetails::class.java))
                }
            }
        }

    }



}
