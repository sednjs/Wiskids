package com.example.wiskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class FracDec : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frac_dec)
        init()
    }
    private fun init(){
        val btn1 = findViewById<Button>(R.id.buttonf)
        val btn2 = findViewById<Button>(R.id.buttond)
        val back = findViewById<ImageView>(R.id.fd_back1)

        btn1.setOnClickListener {
            val intent = Intent(this, frac_game::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, dec_game::class.java)
            startActivity(intent)
        }
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}