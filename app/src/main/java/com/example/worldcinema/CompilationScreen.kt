package com.example.worldcinema

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.worldcinema.retrofit.RetrofitInstance
import kotlinx.android.synthetic.main.activity_chat_list_screen.*
import kotlinx.android.synthetic.main.activity_compilation_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompilationScreen : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compilation_screen)

        val service = RetrofitInstance.api
        val call_last = service.getLast("compilation")
        call_last.enqueue(object : Callback<List<FilmsModel>> {
            override fun onResponse(call: Call<List<FilmsModel>>, response: Response<List<FilmsModel>>) {
                Log.d("RETROFIT", response.body().toString())
                val result : List<FilmsModel> = response.body() as List<FilmsModel>
                val adapter3 = ChatAdapter(result)
                Log.d("RETROFIT", result.toString())
                my_rv.adapter = adapter3
                my_rv.layoutManager = LinearLayoutManager(this@CompilationScreen)

            }

            override fun onFailure(call: Call<List<FilmsModel>>, t: Throwable) {
                Log.d("RETROFIT", "ERROR")
            }
        })
    }

    fun goMain3(view: View) {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
    }
}