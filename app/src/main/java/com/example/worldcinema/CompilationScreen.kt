package com.example.worldcinema

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class CompilationScreen : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compilation_screen)

    }

    fun goMain3(view: View) {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
    }
}