package com.example.wiskids

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wiskids.databinding.ResultBinding

class ResultActivity:AppCompatActivity() {
    lateinit var binding: ResultBinding
    var score:Int = 0
    var time:Long = 0
    var questions:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        val b = getIntent().getExtras()
        score = -1 // or other values
        if(b != null) {
            score = b.getInt("key")
            time = b.getLong("key2")
            questions = b.getInt("key3")
        }

        val result = binding.root.findViewById<TextView>(R.id.scoretxt)

        result.setText("You answered all questions in "+time+" seconds !\nYour Score is "+score+"/"+questions+" !\nKeep up the good work!")

        val homebtn =  binding.root.findViewById<Button>(R.id.home)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}