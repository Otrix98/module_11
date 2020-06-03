package com.example.module_11

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class Adapter(
    private  val screens: List<ArticalScreen>,
    fragment: ViewPagerFragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return screens.size
    }

    override fun createFragment(position: Int): Fragment {
        val screen: ArticalScreen = screens[position]
        return ArticleFragment.newInstance(
            textRes = screen.textRes,
            drawableRes = screen.drawableRes
        )
    }
}