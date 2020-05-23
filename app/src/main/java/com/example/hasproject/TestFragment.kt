package com.example.hasproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TestFragment : Fragment() {

    private var page : Int? = null
    private var title : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        page = arguments?.getInt("page")
        title = arguments?.getString("title")
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false)

        val tv_category :TextView = view.findViewById(R.id.name_category)
        tv_category.text = "$title $page"

        return view
    }

    companion object {
        fun newInstance(page:Int , title:String) : TestFragment{
            val frag1 = TestFragment()
            val args = Bundle()
            args.putInt("page" , page)
            args.putString("title",title)
            frag1.arguments = args
            return frag1
        }
    }

}
