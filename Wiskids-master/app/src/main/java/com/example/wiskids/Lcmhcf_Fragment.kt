package com.example.wiskids

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.random.Random

class Lcmhcf_Fragment : Fragment() {

    lateinit var lcmhcf_concept: LcmhcfConcept_Fragment

    //사진 배열
    val lcmhcf_data:ArrayList<LcmhcfData> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lcmhcf_game, container, false)

        initData() // CountData에 데이터 삽입

        var start = System.currentTimeMillis() //시간 측정

        val question = view.findViewById<TextView>(R.id.ques)
        val answer = view.findViewById<EditText>(R.id.lcmhcfanswer)

        //초기값
        var position = 0
        var type = ""
        if(position < 5)
            type = "Lowest Common Multiple"
        else
            type = "Highest Common Factor"
        question.text = "${position+1}. Find $type of ${lcmhcf_data[position].num1} and  ${lcmhcf_data[position].num2}"
            //(position+1).toString()

        // 컨셉 버튼 이벤트 처리
        val concept: Button = view.findViewById(R.id.lcmhcf_concept_btn)
        concept.setOnClickListener {
            lcmhcf_concept = LcmhcfConcept_Fragment()
            (activity as LcmhcfActivity).replaceView(lcmhcf_concept)
        }

        // back 버튼 기능
        val back: ImageView = view.findViewById(R.id.lcmhcf_back2)
        back.setOnClickListener {
            check_ans(answer,position)
            position--
            if(position>0){
                if(position < 5)
                    type = "Lowest Common Multiple"
                else
                    type = "Highest Common Factor"


                question.text = "${position+1}. Find the $type of ${lcmhcf_data[position].num1} and  ${lcmhcf_data[position].num2}"
                if(lcmhcf_data[position].submit!=0)
                    answer.hint = "The answer you entered: ${lcmhcf_data[position].submit}"
                else
                    answer.hint = "Please enter your answer here"
            }
            else{
                check_ans(answer,position)
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }

        // next 버튼 기능
        val next:ImageView = view.findViewById(R.id.lcmhcf_next)
        next.setOnClickListener{
            if(position<9){
                check_ans(answer,position)
                position++
                if(position < 5)
                    type = "Lowest Common Multiple"
                else
                    type = "Highest Common Factor"


                question.text = "${position+1}. Find $type of ${lcmhcf_data[position].num1} and  ${lcmhcf_data[position].num2}"
                if(lcmhcf_data[position].submit!=0)
                    answer.hint = "The answer you entered: ${lcmhcf_data[position].submit}"
                else
                    answer.hint = "Please enter your answer here"
            }
            else {
                check_ans(answer,position)
                //시간 계산
                var end = System.currentTimeMillis()
                var current = TimeUnit.MILLISECONDS.toSeconds(end - start)
                //정답 계산
                var correct_num: Int = 0
                for (i: Int in 0..9) {
                    if (lcmhcf_data[i].isCorrect == true)
                        correct_num++
                }

                val intent = Intent(context, ResultActivity::class.java)
                val b = Bundle()
                b.putInt("key", correct_num)
                b.putLong("key2", current)
                b.putInt("key3", 10)
                intent.putExtras(b)
                startActivity(intent)
            }
        }

        return view
    }

    private fun initData() {
        val start = 1
        val lcmend = 9
        val hcfend = 99
        var count = 1
        repeat(5){      //LCM
            val num1 = Random(System.nanoTime()).nextInt(start, lcmend+1)
            val num2 = Random(System.nanoTime()).nextInt(start, lcmend+1)
            var lcm = if (num1 > num2) num1 else num2

            // Always true
            while (true) {
                if (lcm % num1 == 0 && lcm % num2 == 0) {
                    break
                }
                ++lcm
            }
            print("$num1, $num2, = $lcm /n")
            lcmhcf_data.add(LcmhcfData(count,num1,num2,0,lcm,false))
            count++
        }
        repeat(5) {      //HCF
            val num1 = Random(System.nanoTime()).nextInt(start, hcfend + 1)
            val num2 = Random(System.nanoTime()).nextInt(start, hcfend + 1)
            var hcf = 1

            var i = 1
            while (i <= num1 && i <= num2) {
                // Checks if i is factor of both integers
                if (num1 % i == 0 && num2 % i == 0)
                    hcf = i
                ++i
            }
            print("$num1, $num2, = $hcf /n")
            lcmhcf_data.add(LcmhcfData(count,num1,num2,0,hcf,false))
            count++
        }
    }

    // 입력한 답 체크
    private fun check_ans(answer:EditText, position:Int) {
        if(answer.text.toString().length>0) { // answer edittext에 답을 입력한 경우
            lcmhcf_data[position].submit = answer.text.toString().toInt() // 입력한 답 저장

            if(lcmhcf_data[position].answer == lcmhcf_data[position].submit) { // 입력한 답과 그림에 해당하는 숫자가 같을 경우
                lcmhcf_data[position].isCorrect = true
                print("${position+1} 번 맞췄어요\n")
            }
            else {
                lcmhcf_data[position].isCorrect = false
                print("${position + 1} 번 틀렸어요\n")
            }

            answer.text.clear()
        }
    }


}