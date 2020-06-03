package com.example.module_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kotlinx.android.synthetic.main.fragment_viewpager.viewPager

class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showViewPagerFragment()


    }

    private fun showViewPagerFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ViewPagerFragment())
            .commit()
    }
}
