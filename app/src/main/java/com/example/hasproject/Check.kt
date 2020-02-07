package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_check.*

class Check : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        next_to_step2.setOnClickListener {
            val intentForGetStep2 = Intent(this, SecondCheck::class.java)
            startActivity(intentForGetStep2)
        }

        finish_step1.setOnClickListener {
            finish()
        }
    }
}
