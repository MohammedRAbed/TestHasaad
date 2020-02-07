package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second_check.*

class SecondCheck : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_check)

        finish_step2.setOnClickListener {
            finish()
        }
        next_to_step3.setOnClickListener {
            val intentForGetStep3 = Intent(this, ThirdCheck::class.java)
            startActivity(intentForGetStep3)
        }

        credit.setOnClickListener {
            credit.setImageResource(R.drawable.ic_f_check)
        }

        deliviry.setOnClickListener {
            deliviry.setImageResource(R.drawable.ic_s_check)
        }

        f_t.setOnClickListener {
            f_t.setImageResource(R.drawable.ic_t_check)
        }

        a_points.setOnClickListener {
            a_points.setImageResource(R.drawable.ic_r_check)
        }


    }
}
