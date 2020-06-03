package com.example.module_11

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_viewpager.*

class ViewPagerFragment: Fragment(R.layout.fragment_viewpager) {

    private val screens: List<ArticalScreen> = listOf(
        ArticalScreen(
            textRes = R.string.text_1,
            drawableRes = R.drawable.drawable_1
        ),
        ArticalScreen(
            textRes = R.string.text_2,
            drawableRes = R.drawable.drawable_2
        ),
        ArticalScreen(
            textRes = R.string.text_3,
            drawableRes = R.drawable.drawable_3
        ),
        ArticalScreen(
            textRes = R.string.text_4,
            drawableRes = R.drawable.drawable_4
        ),
        ArticalScreen(
            textRes = R.string.text_5,
            drawableRes = R.drawable.drawable_5
        ),
        ArticalScreen(
            textRes = R.string.text_6,
            drawableRes = R.drawable.drawable_1
        ),
        ArticalScreen(
            textRes = R.string.text_7,
            drawableRes = R.drawable.drawable_7
        ),
        ArticalScreen(
            textRes = R.string.text_8,
            drawableRes = R.drawable.drawable_8
        )
    )
    

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val adapter = Adapter(screens, fragment = ViewPagerFragment())
        viewPager.adapter = adapter
//        viewPager.offscreenPageLimit = 1
    }




}