package com.example.wiskids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class CountActivity : AppCompatActivity() {

    lateinit var count_game: CountGame_Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        count_game = CountGame_Fragment()

        //count activity에서 처음으로 보여지는 fragment
        supportFragmentManager.beginTransaction().add(R.id.countframeLayout, count_game).commit()

    }

    //fragment 변경
    fun replaceView(tab: Fragment) {
        var selectedFragment : Fragment? = null
        selectedFragment = tab
        selectedFragment?.let{
            supportFragmentManager.beginTransaction().replace(R.id.countframeLayout, it).commit()
        }
    }

}