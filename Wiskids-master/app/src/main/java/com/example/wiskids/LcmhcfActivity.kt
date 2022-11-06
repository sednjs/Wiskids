package com.example.wiskids

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class LcmhcfActivity :AppCompatActivity(){
    lateinit var lcmhcf_game: Lcmhcf_Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lcmhcf)

        lcmhcf_game = Lcmhcf_Fragment()

        //count activity에서 처음으로 보여지는 fragment
        supportFragmentManager.beginTransaction().add(R.id.lhframeLayout, lcmhcf_game).commit()

    }

    //fragment 변경
    fun replaceView(tab: Fragment) {
        var selectedFragment : Fragment? = null
        selectedFragment = tab
        selectedFragment?.let{
            supportFragmentManager.beginTransaction().replace(R.id.lhframeLayout, it).commit()
        }
    }

}
