package com.example.wiskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.wiskids.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init(){

        // 레벨1 버튼 이벤트 처리
        val level1 = binding.root.findViewById<Button>(R.id.level1)

        level1.setOnClickListener {
            val intent = Intent(this, CountActivity::class.java)
            startActivity(intent)
        }

        // 레벨2 버튼 이벤트 처리
        val level2 = findViewById<Button>(R.id.level2)

        level2.setOnClickListener {
            val intent = Intent(this, CalcActivity::class.java)
            startActivity(intent)
        }

        // 레벨3 버튼 이벤트 처리
        val level3 = findViewById<Button>(R.id.level3)

        level3.setOnClickListener {
            val intent = Intent(this, FracDec::class.java)
            startActivity(intent)
        }

        val level4 = findViewById<Button>(R.id.level4)

        level4.setOnClickListener {
            val intent = Intent(this, LcmhcfActivity::class.java)
            startActivity(intent)
        }

        val leveltest=binding.root.findViewById<Button>(R.id.leveltest)

        leveltest.setOnClickListener {
            val intent = Intent(this, LeveltestGameActivity::class.java)
            startActivity(intent)
        }

    }

}