package com.example.worldcinema

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainScreen : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

    fun goChat(view: View) {
        val intent = Intent(this, ChatListScreen::class.java)
        startActivity(intent)
    }

    fun goSignIn(view: View) {
        val intent = Intent(this, SignInScreen::class.java)
        startActivity(intent)
    }
    fun goLove(view: View) {
        val intent = Intent(this, FavoritesScreen::class.java)
        startActivity(intent)
    }
    fun goPod(view: View) {
        val intent = Intent(this, CompilationScreen::class.java)
        startActivity(intent)
    }
}