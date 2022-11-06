package com.example.wiskids

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class LcmhcfConcept_Fragment : Fragment() {

    lateinit var lcmhcf_game: Lcmhcf_Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lcmhcf_concept, container, false)

        // back 버튼 눌렀을 때 게임화면으로 돌아감
        val back:ImageView = view.findViewById(R.id.lh_back1)
        back.setOnClickListener {
            lcmhcf_game = Lcmhcf_Fragment()
            (activity as LcmhcfActivity).replaceView(lcmhcf_game)
        }

        return view
    }



}