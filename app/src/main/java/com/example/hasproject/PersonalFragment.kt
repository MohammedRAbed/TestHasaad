package com.example.hasproject


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.account_personal.*
import kotlinx.android.synthetic.main.account_personal.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PersonalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val viewToPersonal = inflater.inflate(R.layout.account_personal, container, false)



        viewToPersonal.go_points.setOnClickListener {
            var intintForGoPoints = Intent(context , MyPoints::class.java)
            startActivity(intintForGoPoints)
        }

        viewToPersonal.to_settings.setOnClickListener {
            var intintForGoToSettings = Intent(context , Settings::class.java)
            startActivity(intintForGoToSettings)
        }

        viewToPersonal.go_from_acccount_to_cart.setOnClickListener {
            var intintForGoFromAccountToCart = Intent(context , Cart::class.java)
            startActivity(intintForGoFromAccountToCart)
        }


        // Inflate the layout for this fragment
        return viewToPersonal
    }


}
