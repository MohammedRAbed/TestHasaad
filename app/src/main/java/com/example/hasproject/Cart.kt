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
import com.example.hasproject.saveData.CartClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_ad_to_cart_dialog.view.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_order_note.*
import kotlinx.android.synthetic.main.activity_order_note.view.*
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.android.synthetic.main.cart_list.*

/*
 List<YourModel> arrayItems;
 String serializedObject = sharedPreferences.getString(KEY_PREFS, null);
 if (serializedObject != null) {
 Gson gson = new Gson();
 Type type = new TypeToken<List<YourModel>>(){}.getType();
 arrayItems = gson.fromJson(serializedObject, type);
 }
 */

class Cart : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val sp = getSharedPreferences("SP", Context.MODE_PRIVATE)
        val gson = Gson()
        val json  = sp.getString("KEY","")
        val type = object : TypeToken<List<CartClass>>() {}.type

        val list :List<CartClass> = gson.fromJson(json,type)


        val recyclerViewForCart: RecyclerView = findViewById(R.id.recyclerView_for_cart)
        recyclerViewForCart.layoutManager = LinearLayoutManager(this)
/*
        val cartFood = ArrayList<CartClass>()

        val sharedPreferences = getSharedPreferences("SP_Info", Context.MODE_PRIVATE)

        val many = sharedPreferences.getString("MANY","1")
        val des =sharedPreferences.getString("DES","no extra description")

        val p_name = sharedPreferences.getString("NAME","")
        val price =sharedPreferences.getString("PRICE","")

        cartFood.add(CartClass(p_name,many,price,des))

*/
        val myAdapterForCart = Cart.CoustumAdapterForCart(this)
        recyclerViewForCart.adapter = myAdapterForCart
        myAdapterForCart.setCartList(list)





        check_cart.setOnClickListener {
            val mDialogView2 = LayoutInflater.from(this).inflate(R.layout.activity_order_note,null)
            val mBuilder2 = AlertDialog.Builder(this)
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





    }




    class CoustumAdapterForCart(var context: Context):RecyclerView.Adapter<CoustumAdapterForCart.myCartHolder>(){

        var cartt_list :List<CartClass> = listOf()

       override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myCartHolder {
            var z = LayoutInflater.from(p0?.context).inflate(R.layout.cart_list,p0,false)
            return myCartHolder(z)
        }

        override fun getItemCount(): Int {
            return cartt_list.size
        }

        override fun onBindViewHolder(p0: myCartHolder, position: Int) {
            val related : CartClass = cartt_list[position]

            p0?.theNameOfCart.text = related.name
            p0?.theManyOfCart.text = "${related.many}"
            p0?.thePriceOfCart.text = related.price
            p0?.theDescriptionOfCart.text = related.des

        }

        fun setCartList(list : List<CartClass>) {
            this.cartt_list = list
            notifyDataSetChanged()
        }

         inner class myCartHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            var theImageForCart :ImageView
            var theNameOfCart:TextView
            var theManyOfCart :TextView
            var thePriceOfCart :TextView
            var theDescriptionOfCart :TextView


            init {
                theImageForCart = itemView.findViewById(R.id.image_cart) as ImageView
                 theNameOfCart = itemView.findViewById(R.id.name_cart) as TextView
                 theManyOfCart = itemView.findViewById(R.id.many_x_items_cart) as TextView
                 thePriceOfCart = itemView.findViewById(R.id.price_cart) as TextView
                theDescriptionOfCart = itemView.findViewById(R.id.description_cart) as TextView




            }
        }


    }




}
