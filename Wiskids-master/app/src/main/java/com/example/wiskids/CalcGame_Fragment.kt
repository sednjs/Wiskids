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

class CalcGame_Fragment : Fragment() {

    lateinit var calc_concept: CalcConcept_Fragment

    //사진 배열
    val imgList = arrayListOf<Int>(R.drawable.calc1,R.drawable.calc2,R.drawable.calc3,R.drawable.calc4,R.drawable.calc5,R.drawable.calc6,R.drawable.calc7,R.drawable.calc8,R.drawable.calc9,R.drawable.calc10)
    val calc_data:ArrayList<CalcData> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calc_game_, container, false)

        initData() // CalcData에 데이터 삽입

        // 시간정보를 이용해서 배열 shuffle
        var seed = System.nanoTime()
        Collections.shuffle(calc_data, Random(seed))

        var start = System.currentTimeMillis() //시간 측정

        val question = view.findViewById<TextView>(R.id.calc_question)
        val picture = view.findViewById<ImageView>(R.id.calc_pic)
        val answer = view.findViewById<EditText>(R.id.calc_ans)

        //초기값
        var position = 0
        question.text = (position+1).toString()
        picture.setImageResource(calc_data[position].picture)

        // 컨셉 버튼 이벤트 처리
        val concept: Button = view.findViewById(R.id.calc_concept_btn)
        concept.setOnClickListener {
            calc_concept = CalcConcept_Fragment()
            (activity as CalcActivity).replaceView(calc_concept)
        }

        // back 버튼 기능
        val back: ImageView = view.findViewById(R.id.calc_back2)
        back.setOnClickListener {
            if(position>0){
                check_ans(answer,position)
                position--
                question.text = (position+1).toString()
                picture.setImageResource(calc_data[position].picture)
                if(calc_data[position].answer!=0)
                    answer.hint = "The answer you entered: ${calc_data[position].answer}"
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
        val next: ImageView = view.findViewById(R.id.calc_next)
        next.setOnClickListener{
            if(position<9){
                check_ans(answer,position)
                position++
                question.text = (position+1).toString()
                picture.setImageResource(calc_data[position].picture)
                if(calc_data[position].answer!=0)
                    answer.hint = "The answer you entered: ${calc_data[position].answer}"
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
                    if (calc_data[i].isCorrect == true)
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
        for(i:Int in 0..9){
            calc_data.add(CalcData(imgList[i], i+1, 0, false))
        }
    }

    // 입력한 답 체크
    private fun check_ans(answer: EditText, position:Int) {
        if(answer.text.toString().length>0) { // answer edittext에 답을 입력한 경우
            calc_data[position].answer = answer.text.toString().toInt() // 입력한 답 저장

            if(calc_data[position].answer == calc_data[position].count) { // 입력한 답과 그림에 해당하는 숫자가 같을 경우
                calc_data[position].isCorrect = true
                print("${position+1} 번 맞췄어요\n")
            }
            else {
                calc_data[position].isCorrect = false
                print("${position + 1} 번 틀렸어요\n")
            }

            answer.text.clear()
        }
    }


}