package com.example.hasproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hasproject.deleteProduct.SwipeToDelete
import com.example.hasproject.saveData.CartClass
import com.example.hasproject.saveData.cartList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_ad_to_cart_dialog.view.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_order_note.*
import kotlinx.android.synthetic.main.activity_order_note.view.*
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.android.synthetic.main.cart_list.*


class Cart : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val sp = getSharedPreferences("SP", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sp.getString("KEY", "")
        val typeToken = object : TypeToken<List<CartClass>>() {}.type

        val list: ArrayList<CartClass> = gson.fromJson(json, typeToken)

        var total: Double = 0.0
        for (i in list.indices) {
            when (i) {
                0 -> {
                    total = list.get(i).price.toDouble()
                }
                else -> {
                    total += list.get(i).price.toDouble()
                }
            }
        }
        total_cart.text = "$total SR"
        check_cart.text = "Check out ($total SR)"

        val recyclerViewForCart: RecyclerView = findViewById(R.id.recyclerView_for_cart)
        recyclerViewForCart.layoutManager = LinearLayoutManager(this)
        val myAdapterForCart = Cart.CoustumAdapterForCart(this)
        recyclerViewForCart.adapter = myAdapterForCart
        myAdapterForCart.setCartList(list)


        //Swipe To Delete....
        val swipeToDeleteCallback : SwipeToDelete = object :SwipeToDelete(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position : Int = viewHolder.adapterPosition
                val item : CartClass = myAdapterForCart.geetData()[position]

                if (list.size != 1) {
                    println("size --------> ${list.size}")
                    total -= list[position].price.toDouble()
                    total_cart.text = "$total SR"
                    check_cart.text = "Check out ($total SR)"
                } else {
                    check_cart.setBackgroundColor(Color.parseColor("#F7F7F7"))
                    check_cart.text = "The Cart is empty"
                    total_cart.text = "0 SR"
                    check_cart.setTextColor(Color.parseColor("#216E5F"))
                }

                myAdapterForCart.removeItem(position)



                val snackbar = Snackbar.make(constaint_cart, "Product was removed from the list.", Snackbar.LENGTH_LONG)
                snackbar.setAction("UNDO ?", object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        myAdapterForCart.restoreItem(item, position)
                        recyclerViewForCart.scrollToPosition(position)
                    }
                })
                snackbar.setActionTextColor(Color.YELLOW)
                snackbar.show()
            }
        }
        val itemTouchhelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchhelper.attachToRecyclerView(recyclerViewForCart)





        check_cart.setOnClickListener {
            val mDialogView2 = LayoutInflater.from(this).inflate(R.layout.activity_order_note, null)
            val mBuilder2 = AlertDialog.Builder(this)
                .setView(mDialogView2)

            var mAlertDialog2 = mBuilder2.show()


            mDialogView2.done_note.setOnClickListener {
                val intentForGoToCheck = Intent(this, Check::class.java)
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






    //Adapter.....
    class CoustumAdapterForCart(var context: Context) :
        RecyclerView.Adapter<CoustumAdapterForCart.myCartHolder>() {

        var cartt_list: ArrayList<CartClass> = ArrayList()

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myCartHolder {
            var z = LayoutInflater.from(p0.context).inflate(R.layout.cart_list, p0, false)
            return myCartHolder(z)
        }

        override fun getItemCount(): Int {
            return cartt_list.size
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(p0: myCartHolder, position: Int) {
            val related: CartClass = cartt_list[position]

            p0.theNameOfCart.text = related.name
            p0.theManyOfCart.text = related.many
            p0.thePriceOfCart.text = related.price + " SR"
            p0.theDescriptionOfCart.text = related.des
            p0.theTypeOfCart.text = " " + related.type


        }

        fun setCartList(list: ArrayList<CartClass>) {
            this.cartt_list = list
            notifyDataSetChanged()
        }


        fun removeItem(position: Int) {
            cartt_list.removeAt(position)
            notifyItemRemoved(position)
        }

        fun restoreItem(item: CartClass?, position: Int) {
            cartt_list.add(position, item!!)
            notifyItemInserted(position)
        }

        fun geetData(): ArrayList<CartClass> {
            return cartt_list
        }


        inner class myCartHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var theImageForCart: ImageView
            var theNameOfCart: TextView
            var theManyOfCart: TextView
            var thePriceOfCart: TextView
            var theDescriptionOfCart: TextView
            var theTypeOfCart: TextView


            init {
                theImageForCart = itemView.findViewById(R.id.image_cart) as ImageView
                theNameOfCart = itemView.findViewById(R.id.name_cart) as TextView
                theManyOfCart = itemView.findViewById(R.id.many_x_items_cart) as TextView
                thePriceOfCart = itemView.findViewById(R.id.price_cart) as TextView
                theDescriptionOfCart = itemView.findViewById(R.id.description_cart) as TextView
                theTypeOfCart = itemView.findViewById(R.id.type_cart) as TextView

            }
        }


    }


}
