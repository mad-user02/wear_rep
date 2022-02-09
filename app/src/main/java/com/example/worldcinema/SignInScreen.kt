package com.example.worldcinema

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.worldcinema.model.LoginModel
import com.example.worldcinema.model.Token
import com.example.worldcinema.retrofit.RetrofitInstance
import kotlinx.android.synthetic.main.activity_sign_in_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInScreen : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_screen)

    }

    fun goMainScreen(view: View) {
        if (email.text.isEmpty() || password.text.isEmpty()) {
            Log.d("SignUpScreenMessage", "Ошибка.Пожалуйста введите текст.")
        }
        else {
            val service = RetrofitInstance.api
            val email = email.text
            val password = password.text
            val call_login = service.getLogin(LoginModel(email.toString(), password.toString()))
            Log.d("AAAAAA", "!")
            call_login.enqueue(object : Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    Log.d("RETROFIT", "ok")
                    val intent = Intent(this@SignInScreen, MainScreen::class.java)
                    startActivity(intent)
                }

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Log.d("RETROFIT", "Ошибка.")
                }

            })
        }
    }
}