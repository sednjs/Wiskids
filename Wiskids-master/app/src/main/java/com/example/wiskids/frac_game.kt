package com.example.wiskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.wiskids.databinding.ActivityFracGameBinding
import java.util.concurrent.TimeUnit

class frac_game : AppCompatActivity() {
    lateinit var binding: ActivityFracGameBinding
    val que = arrayOf(R.drawable.fq10, R.drawable.fq1, R.drawable.fq3, R.drawable.fq2, R.drawable.fq7)
    val answer = arrayListOf<String>("6/7","4/5","2/4","3/8","7/12")
    val ques=arrayListOf<String>("1.","2.","3.","4.","5.")
    var score = 0
    var current:Long = 0
    val correct=Array(5){i->false}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFracGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fracinit()
        concept()
    }

    private fun fracinit() {
        var num = 0
        var start = System.currentTimeMillis()
        binding.apply {
            iv.setImageResource(que[num])
            question.setText(ques[num])
            next.setOnClickListener {
                if(num<4){
                    if(ans.text.toString().isNotEmpty()){
                        if (answer[num] == ans.text.toString()) {
                            correct[num]=true
                            score += 1
                        }
                    }
                    num++
                    iv.setImageResource(que[num])
                    question.setText(ques[num])
                    ans.text.clear()
                }else{
                    if(ans.text.toString().isNotEmpty()){
                        if (answer[num] == ans.text.toString())
                            score += 1
                    }
                    var end = System.currentTimeMillis()
                    current = TimeUnit.MILLISECONDS.toSeconds(end-start)
                    fininit()
                }
            }
            back.setOnClickListener{
                if(num>0){
                    num--
                    iv.setImageResource(que[num])
                    question.setText(ques[num])
                    ans.text.clear()

                    if(correct[num]==true){
                        score--
                    }

                }else{
                    tomain()
                }

            }
        }
    }

    private fun fininit() {
        val intent = Intent(this, ResultActivity::class.java)
        val b = Bundle()
        b.putInt("key", score)
        b.putLong("key2", current)
        b.putInt("key3", 5)
        intent.putExtras(b)
        startActivity(intent)
    }
    private fun concept(){
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, Concept_expl::class.java)
            startActivity(intent)
        }
    }
    private fun tomain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}