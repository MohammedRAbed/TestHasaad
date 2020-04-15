package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.IntentCompat
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_on_boarding.*

class FinishSignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_sign_up)


        get_start.setOnClickListener {
            var intintForGetStart = Intent(this , MainHome::class.java)
            intintForGetStart.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intintForGetStart)
            finish()
        }
    }


}
