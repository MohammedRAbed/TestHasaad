package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        to_login.setOnClickListener {
            var intintForLogIn = Intent(this , MainHome::class.java)
            startActivity(intintForLogIn)
        }

        to_forget_password.setOnClickListener {
            var intintForForgetPassword1 = Intent(this , FirstForgetPassword::class.java)
            startActivity(intintForForgetPassword1)
        }

        from_signin_to_boarding.setOnClickListener {
            finish()
        }
    }
}
