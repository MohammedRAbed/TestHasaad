package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_first_sign_up.*
import kotlinx.android.synthetic.main.activity_on_boarding.*

class FirstSignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_sign_up)

        to_signup2.setOnClickListener {
            var intintForSignup1 = Intent(this , SecondSignUp::class.java)
            startActivity(intintForSignup1)
        }
        back_from_1_to_boarding.setOnClickListener {
            finish()
        }
    }


}
