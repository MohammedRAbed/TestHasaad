package com.example.hasproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_points.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class MyPoints : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_points)

        back_from_points_to_account.setOnClickListener {
            finish()
        }
    }
}
