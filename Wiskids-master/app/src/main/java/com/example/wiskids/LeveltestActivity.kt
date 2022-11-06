package com.example.wiskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.wiskids.databinding.ActivityLeveltestBinding
import com.google.android.material.textfield.TextInputEditText
import java.util.ArrayList
import kotlin.random.Random

class LeveltestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLeveltestBinding
    val data = arrayListOf<String>("3", "8", "5", "10", "1.85", "7/12", "5", "42")
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeveltestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        leveltestinit()
    }

    private fun leveltestinit() {
        val fin = binding.root.findViewById<Button>(R.id.fin)

        binding.apply {
            fin.setOnClickListener {    //score 계산
                if (ans1.text.toString().isNotEmpty() && ans2.text.toString()
                        .isNotEmpty() && ans3.text.toString().isNotEmpty() &&
                    ans4.text.toString().isNotEmpty() && ans5.text.toString()
                        .isNotEmpty() && ans6.text.toString().isNotEmpty() &&
                    ans7.text.toString().isNotEmpty() && ans8.text.toString()
                        .isNotEmpty())
                {
                    if (data[0] == ans1.text.toString())
                        score += 1
                    if (data[1] == ans2.text.toString())
                        score += 1
                    if (data[2] == ans3.text.toString())
                        score += 1
                    if (data[3] == ans4.text.toString())
                        score += 1
                    if (data[4] == ans5.text.toString())
                        score += 1
                    if (data[5] == ans6.text.toString())
                        score += 1
                    if (data[6] == ans7.text.toString())
                        score += 1
                    if (data[7] == ans8.text.toString())
                        score += 1

                    fininit()
                }


            }
        }
    }

    private fun fininit(){
        val intent=Intent(this, LevelResultActivity::class.java)
        val b=Bundle()
        b.putInt("key",score)
        intent.putExtras(b)
        startActivity(intent)

    }
}
/*원래 코드 시작*/

//    private fun init(){
//
//        var score = 0
//
//        val ans1  = binding.root.findViewById<TextInputEditText>(R.id.ans1)
//        val ans2 = binding.root.findViewById<TextInputEditText>(R.id.ans2)
//        val ans3 = binding.root.findViewById<TextInputEditText>(R.id.ans3)
//        val ans4 = binding.root.findViewById<TextInputEditText>(R.id.ans4)
////        val ans5 = binding.root.findViewById<TextInputEditText>(R.id.ans5)
////        val ans6 = binding.root.findViewById<TextInputEditText>(R.id.ans6)
////        val ans7 = binding.root.findViewById<TextInputEditText>(R.id.ans7)
////        val ans8 = binding.root.findViewById<TextInputEditText>(R.id.ans8)
////        val ans9 = binding.root.findViewById<TextInputEditText>(R.id.ans9)
////        val ans10 = binding.root.findViewById<TextInputEditText>(R.id.ans10)
//        val fin = binding.root.findViewById<Button>(R.id.fin)
//        val ques1 = binding.root.findViewById<TextView>(R.id.ques1)
//        val ques2 = binding.root.findViewById<TextView>(R.id.ques2)
//        val ques3 = binding.root.findViewById<TextView>(R.id.ques3)
//        val ques4 = binding.root.findViewById<TextView>(R.id.ques4)
////        val ques5 = binding.root.findViewById<TextView>(R.id.ques5)
////        val ques6 = binding.root.findViewById<TextView>(R.id.ques6)
////        val ques7 = binding.root.findViewById<TextView>(R.id.ques7)
////        val ques8 = binding.root.findViewById<TextView>(R.id.ques8)
////        val ques9 = binding.root.findViewById<TextView>(R.id.ques9)
////        val ques10 = binding.root.findViewById<TextView>(R.id.ques10)
//
//        ques1.setText("Find LCM of  "+data[0].num1.toString()+" & "+data[0].num2.toString())
//        ques2.setText("Find HCF of  "+data[1].num1.toString()+" & "+data[1].num2.toString())
//        ques3.setText("Count the following objects")
//        ques4.setText("Count the following objects")
////        ques5.setText("Find LCM of  "+data[4].num1.toString()+" & "+data[4].num2.toString())
////        ques6.setText("Find HCF of  "+data[5].num1.toString()+" & "+data[5].num2.toString())
////        ques7.setText("Find HCF of  "+data[6].num1.toString()+" & "+data[6].num2.toString())
////        ques8.setText("Find HCF of  "+data[7].num1.toString()+" & "+data[7].num2.toString())
////        ques9.setText("Find HCF of  "+data[8].num1.toString()+" & "+data[8].num2.toString())
////         ques10.setText("Find HCF of  "+data[9].num1.toString()+" & "+data[9].num2.toString())
//
//
//
//        fin.setOnClickListener{
//            if(ans1.text.toString().isNotEmpty() && ans2.text.toString().isNotEmpty()) {
//
//                if (data[0].lcmhcf == ans1.text.toString().toInt())
//                    score += 1
//                if (data[1].lcmhcf == ans2.text.toString().toInt())
//                    score += 1
////                if (data[2].lcmhcf == ans3.text.toString().toInt())
////                    score += 1
////                if (data[3].lcmhcf == ans4.text.toString().toInt())
////                    score += 1
////                if (data[4].lcmhcf == ans5.text.toString().toInt())
////                    score += 1
////                if (data[5].lcmhcf == ans6.text.toString().toInt())
////                    score += 1
////                if (data[6].lcmhcf == ans7.text.toString().toInt())
////                    score += 1
////                if (data[7].lcmhcf == ans8.text.toString().toInt())
////                    score += 1
////                if (data[8].lcmhcf == ans9.text.toString().toInt())
////                    score += 1
////                if (data[9].lcmhcf == ans10.text.toString().toInt())
////                    score += 1
//
//
//                val intent = Intent(this, LevelResultActivity::class.java)
//                val b = Bundle()
//                b.putInt("key", score)
//                intent.putExtras(b)
//                startActivity(intent)
//
//            }
//
//
//        }
//
//    }
/*원래 코드 끝*/
//}