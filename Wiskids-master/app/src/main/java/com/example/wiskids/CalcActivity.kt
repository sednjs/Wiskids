package com.example.wiskids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class CalcActivity : AppCompatActivity() {

    lateinit var calc_game: CalcGame_Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        calc_game = CalcGame_Fragment()

        //count activity에서 처음으로 보여지는 fragment
        supportFragmentManager.beginTransaction().add(R.id.calcframeLayout, calc_game).commit()

    }

    //fragment 변경
    fun replaceView(tab: Fragment) {
        var selectedFragment : Fragment? = null
        selectedFragment = tab
        selectedFragment?.let{
            supportFragmentManager.beginTransaction().replace(R.id.calcframeLayout, it).commit()
        }
    }

}