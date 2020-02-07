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
import android.widget.TextView
import kotlinx.android.synthetic.main.orders.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class OrdersFragment : Fragment() {

    class OrdersClass()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewToOrder = inflater.inflate(R.layout.orders, container, false)

        val recyclerViewForOrders: RecyclerView = viewToOrder.recyclerView_for_orders
        recyclerViewForOrders.layoutManager = LinearLayoutManager(context)

        val orderss = ArrayList<OrdersClass>()

        orderss.add(OrdersClass())
        orderss.add(OrdersClass())
        orderss.add(OrdersClass())
        orderss.add(OrdersClass())

        val myAdapterForOrders = CoustumAdapterForOrders(orderss,context!!)
        recyclerViewForOrders.adapter = myAdapterForOrders


        return viewToOrder
        // Inflate the layout for this fragment
        return viewToOrder
    }


    class CoustumAdapterForOrders(val orders_food_list :ArrayList<OrdersClass>,val context: Context) :RecyclerView.Adapter<CoustumAdapterForOrders.myOrdersAdapter> () {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CoustumAdapterForOrders.myOrdersAdapter {
            var d = LayoutInflater.from(p0?.context).inflate(R.layout.orders_list,p0,false)
            return myOrdersAdapter(d)
        }

        override fun getItemCount(): Int {
            return orders_food_list.size
        }

        override fun onBindViewHolder(p0: CoustumAdapterForOrders.myOrdersAdapter, p1: Int) {
            val orders_food : OrdersClass = orders_food_list[p1]
        }

        inner class myOrdersAdapter(itemView: View):RecyclerView.ViewHolder(itemView) {
            val intent:Intent? = null
            var theCodeOfOrder :TextView
            var theConditionOfOrder :TextView
            var thePriceOfOrder:TextView
            var theDateOfOrder :TextView

            init {
                theCodeOfOrder = itemView.findViewById(R.id.code_order) as TextView
                 theConditionOfOrder = itemView.findViewById(R.id.condition_order) as TextView
                 thePriceOfOrder = itemView.findViewById(R.id.price_order) as TextView
                 theDateOfOrder = itemView.findViewById(R.id.date_order) as TextView

                itemView.setOnClickListener {
                    context.startActivity(Intent(context,OrderDetails::class.java))
                }
            }
        }
    }

}
