package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        sign_in.setOnClickListener {
            var intintForSignin = Intent(this , SignInActivity::class.java)
            startActivity(intintForSignin)
        }

        sign_up.setOnClickListener {
            var intintForSignup = Intent(this , FirstSignUp::class.java)
            startActivity(intintForSignup)
        }

        skip.setOnClickListener {
            val intentForSkip = Intent(this, MainHome::class.java)
            startActivity(intentForSkip)
            finish()
        }
    }
}
