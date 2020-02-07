package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second_forget_password.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SecondForgetPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_forget_password)

        to_get_start2.setOnClickListener {
            var intintForGetStart = Intent(this , FinishSignUp::class.java)
            startActivity(intintForGetStart)
        }
    }
}
