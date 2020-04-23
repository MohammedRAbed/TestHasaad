package com.example.hasproject


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.products.*
import kotlinx.android.synthetic.main.products.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 *
 */
class ProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewToProduct = inflater.inflate(R.layout.products, container, false)

        val adapter = MyViewPagerAdapter(fragmentManager!!)
        adapter.addFragment(FishFood() , "Fish Food")
        adapter.addFragment(Vegetables() , "Vegetables")
        adapter.addFragment(Fruits() , "Fruits")
        adapter.addFragment(Meat() , "Meat")
        viewToProduct.viewPager.adapter = adapter
        viewToProduct.tabs.setupWithViewPager(viewToProduct.viewPager)


        return viewToProduct
    }


    class MyViewPagerAdapter(manager:FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(p0: Int): Fragment {
            return fragmentList[p0]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

        fun addFragment(fragment: Fragment , title:String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

    }


}
