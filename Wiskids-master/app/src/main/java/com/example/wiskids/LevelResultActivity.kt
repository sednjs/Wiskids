package com.example.wiskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.wiskids.databinding.ActivityLevelresultBinding

class LevelResultActivity : AppCompatActivity() {
    lateinit var binding:ActivityLevelresultBinding
    var score:Int=0
    var time:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLevelresultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        val b = getIntent().getExtras()
        score = -1 // or other values
        if(b != null) {
            score = b.getInt("key")
            time = b.getLong("time")
        }
        val testresult = binding.root.findViewById<TextView>(R.id.score_lev)

        if(score>=0 && score<=2){
            testresult.setText("Your score is "+score+"/8!\nGo to level 1!")
        }else if(score>=3 && score<=4){
            testresult.setText("Your Score is "+score+"/8!\nGo to level 2!")
        }else if(score>=5 && score<=6){
            testresult.setText("Your Score is "+score+"/8!\nGo to level 3!")
        }else if(score>=7 && score<=8){
            testresult.setText("Your Score is "+score+"/8!\nGo to level 4!")
        }


        val homebtn =  binding.root.findViewById<Button>(R.id.home)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}