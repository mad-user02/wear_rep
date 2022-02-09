package com.example.worldcinema

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcinema.retrofit.RetrofitInstance
import kotlinx.android.synthetic.main.activity_chat_list_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChatListScreen : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list_screen)

        val service = RetrofitInstance.api
        val call_movies2 = service.getFilms("forMe")
        call_movies2.enqueue(object : Callback<List<FilmsModel>> {
            override fun onResponse(
                call: Call<List<FilmsModel>>,
                response: Response<List<FilmsModel>>
            ) {
                val result : List<FilmsModel> = response.body() as List<FilmsModel>
                val adapter3 = ChatAdapter(result)
                Log.d("RETROFIT", result.toString())
                chat_rv.adapter = adapter3
                chat_rv.layoutManager = LinearLayoutManager(this@ChatListScreen)

            }

            override fun onFailure(call: Call<List<FilmsModel>>, t: Throwable) {

            }
        })

    }

    fun goMain(view: View) {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
    }
}