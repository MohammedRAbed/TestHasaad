package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_on_boarding.*
import kotlinx.android.synthetic.main.activity_second_sign_up.*

class SecondSignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_sign_up)

        to_signup3.setOnClickListener {
            var intintForSignup2 = Intent(this , ThirdSignUp::class.java)
            startActivity(intintForSignup2)
        }
        back_from_2_to_1.setOnClickListener {
            finish()
        }
    }
}
