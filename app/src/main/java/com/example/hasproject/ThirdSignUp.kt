package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_on_boarding.*
import kotlinx.android.synthetic.main.activity_third_sign_up.*

class ThirdSignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_sign_up)

        to_finish_signup.setOnClickListener {
            var intintForSignup3 = Intent(this , FinishSignUp::class.java)
            startActivity(intintForSignup3)
        }

        back_from3_to_2.setOnClickListener {
            finish()
        }
    }
}
