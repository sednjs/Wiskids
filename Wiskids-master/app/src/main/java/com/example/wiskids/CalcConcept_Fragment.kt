package com.example.wiskids

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class CalcConcept_Fragment : Fragment() {

    lateinit var calc_game: CalcGame_Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calc_concept_, container, false)

        // back 버튼 눌렀을 때 게임화면으로 돌아감
        val back: ImageView = view.findViewById(R.id.calc_back1)
        back.setOnClickListener {
            calc_game = CalcGame_Fragment()
            (activity as CalcActivity).replaceView(calc_game)
        }

        return view
    }



}