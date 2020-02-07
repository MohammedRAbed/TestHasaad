package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_finish_sign_up.*
import kotlinx.android.synthetic.main.activity_first_forget_password.*

class FirstForgetPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_forget_password)

        to_forget_password2.setOnClickListener {
            var intintForForgetPassword2 = Intent(this , SecondForgetPassword::class.java)
            startActivity(intintForForgetPassword2)
        }
        from_forget1_to_signin.setOnClickListener {
            finish()
        }
    }
}
