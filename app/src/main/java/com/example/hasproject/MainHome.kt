package com.example.hasproject

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewPager
import com.example.hasproject.data.model.signin.ForProTabs
import com.example.hasproject.passData.Communicator

class MainHome : AppCompatActivity()/* , Communicator*/ {

    lateinit var homeFragment: HomeFragment
    lateinit var productsFragment: ProductsFragment
    lateinit var ordersFragment: OrdersFragment
    lateinit var favouritFragment: FavouritFragment
    lateinit var personalFragment: PersonalFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)



        val sp = getSharedPreferences("SP", Context.MODE_PRIVATE)


        val email_json = sp.getString("EMAIL","")
        val password_json = sp.getString("PASSWORD","")



        val bottomNavigation :BottomNavigationView =findViewById(R.id.navigationView)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame , homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame , homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_products -> {
                    productsFragment= ProductsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,productsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    return@setOnNavigationItemSelectedListener true

                }

                R.id.navigation_orders -> {
                    ordersFragment= OrdersFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,ordersFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    return@setOnNavigationItemSelectedListener true

                }

                R.id.navigation_favourite -> {
                    favouritFragment= FavouritFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,favouritFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    return@setOnNavigationItemSelectedListener true

                }

                R.id.navigation_account-> {
                    personalFragment= PersonalFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,personalFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    return@setOnNavigationItemSelectedListener true

                }

            }
            false
        }



    }


    class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        var listId : List<ForProTabs.Item> = listOf()

        override fun getItem(p0: Int): Fragment {
            return when (p0) {
                0 -> FishFood.newInstance(1)
                1 -> FishFood.newInstance(2)
                2 -> FishFood.newInstance(3)
                3 -> FishFood.newInstance(4)
                else -> null!!
            }
        }
        override fun getCount(): Int {
             println(listId.size)
            return listId.size
        }
          override fun getPageTitle(position: Int): CharSequence {
            return listId.get(position).title
        }

        fun setData(list : List<ForProTabs.Item>) {
            this.listId = list
            notifyDataSetChanged()
        }


    }



}
