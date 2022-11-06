package com.example.wiskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wiskids.databinding.ActivityLeveltestGameBinding
import java.util.ArrayList
import java.util.concurrent.TimeUnit

class LeveltestGameActivity : AppCompatActivity() {
    lateinit var binding: ActivityLeveltestGameBinding
    val img=arrayOf(R.drawable.img3,R.drawable.img8,R.drawable.calc1,R.drawable.calc3,R.drawable.dq4,R.drawable.fq10,R.drawable.blank,R.drawable.blank)
    val ques=arrayListOf<String>(" 1. How many deers are there?"," 2. How many chicks are there?",
        " 3. Calculate!"," 4. Calculate!"," 5. Caculate the decimals below!", " 6. Caculate the fractions below!",
        " 7. Find Highest Common Factor of 10 and 75?", " 8. Find Lowest Common Multiple of 3 and 14"
        )
    val answer=arrayListOf<String>("3","8","5","10","0.789","6/7","5","42")
    val correct=Array(8){i->false}

    var score=0
    var current:Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLeveltestGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        leveltestinit()
    }

    private fun leveltestinit() {
        var num = 0
        var start = System.currentTimeMillis()
        binding.apply {
            iv.setImageResource(img[num])
            question.setText(ques[num])

            //next click
            next.setOnClickListener {
                if(num<7){
                    if(ans.text.toString().isNotEmpty()){
                        if (answer[num] == ans.text.toString()) {
                            correct[num]=true
                            score += 1
                        }
                    }
                    num++
                    iv.setImageResource(img[num])
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

            //back click
            back.setOnClickListener{
                if(num>0){
                    num--
                    iv.setImageResource(img[num])
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
        val intent=Intent(this, LevelResultActivity::class.java)
        val b=Bundle()
        b.putInt("key",score)
        b.putLong("time", current)
        intent.putExtras(b)
        startActivity(intent)
    }
    private fun tomain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}