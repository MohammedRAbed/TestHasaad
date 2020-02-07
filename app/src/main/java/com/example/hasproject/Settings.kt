package com.example.hasproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.home.*

class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        to_change_info.setOnClickListener {
            var intintForGoToChangeInfo = Intent(this , ChangeInfo::class.java)
            startActivity(intintForGoToChangeInfo)
        }

        back_from_settings_to_account.setOnClickListener {
            finish()
        }
    }
}
