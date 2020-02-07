package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_change_info.*
import kotlinx.android.synthetic.main.home.*

class ChangeInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_info)

        save_to_account.setOnClickListener {
            var intintForSaveAccount = Intent(this , PersonalFragment::class.java)
            startActivity(intintForSaveAccount)
        }

        dont_save_account.setOnClickListener {
            finish()
        }
    }
}
