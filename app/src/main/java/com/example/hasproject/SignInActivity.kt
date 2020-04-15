package com.example.hasproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import com.example.hasproject.data.model.signin.ForLogIn
import com.example.hasproject.data.remote.APIInterface
import com.example.hasproject.data.remote.APIUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInActivity : AppCompatActivity() {

    var mAPIInterface: APIInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val sp = getSharedPreferences("SP", Context.MODE_PRIVATE)


        mAPIInterface = APIUtils().getAPIInterface()
        to_login.setOnClickListener {


            val mobile = et_in_email.text.toString().trim()
            val password = et_in_password.text.toString().trim()

            //are the email & password true?
            if (!TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(password)) {

                //header
                val map: MutableMap<String, String> = HashMap()
                map["Accept-Language"] = "en"
                map["Accept"] = "application/json"

                mAPIInterface?.loginUser(map, mobile, password)!!.enqueue(object : Callback<ForLogIn> {

                    override fun onFailure(call: Call<ForLogIn>?, t: Throwable?) {
                        Toast.makeText(baseContext, "Sorry, try again 🙁", Toast.LENGTH_SHORT)
                            .show()
                    }

                    @SuppressLint("CommitPrefEdits")

                    override fun onResponse(call: Call<ForLogIn>?, response: Response<ForLogIn>?) {
                        if (response!!.body().status == true) {

                            Toast.makeText(baseContext, "Welcome 😃", Toast.LENGTH_SHORT).show()

                            //save data as json
                            val editor = sp.edit()
                            val json_emial = Gson().toJson(mobile)
                            val json_password = Gson().toJson(password)
                            editor.putString("EMAIL" , json_emial)
                            editor.putString("PASSWORD" , json_password)
                            editor.apply()

                            //go to home
                            val intent = Intent(baseContext, MainHome::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            finish()

                        } else {

                            Toast.makeText(
                                baseContext,
                                "check your email and password.",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                        println("response ->" + response)
                        println("response.body ->" + response.body())
                        println("response.code ->" + response.code())
                    }
                })
            } else {
                Toast.makeText(baseContext, "there's an empty value.", Toast.LENGTH_SHORT).show()
            }
        }

        to_forget_password.setOnClickListener {
            val intintForForgetPassword1 = Intent(this, FirstForgetPassword::class.java)
            startActivity(intintForForgetPassword1)
        }

        from_signin_to_boarding.setOnClickListener {
            finish()
        }


    }


}
