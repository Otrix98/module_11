package com.example.module_11

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_viewpager.*


class ViewPagerFragment: Fragment(R.layout.fragment_viewpager) {



    private val screens: List<ArticalScreen> = listOf(
        ArticalScreen(
            tag = listOf(ArticleTag.NEWS, ArticleTag.POLITICAL),
            textRes = R.string.text_1,
            drawableRes = R.drawable.drawable_1
        ),
        ArticalScreen(
            tag = listOf(ArticleTag.NEWS, ArticleTag.POLITICAL),
            textRes = R.string.text_2,
            drawableRes = R.drawable.drawable_2
        ),
        ArticalScreen(
            tag = listOf(ArticleTag.NEWS, ArticleTag.IT),
            textRes = R.string.text_3,
            drawableRes = R.drawable.drawable_3
        ),
        ArticalScreen(
            tag = listOf(ArticleTag.NEWS, ArticleTag.IT),
            textRes = R.string.text_4,
            drawableRes = R.drawable.drawable_4
        ),
        ArticalScreen(
            tag = listOf(ArticleTag.NEWS, ArticleTag.MEDIA),
            textRes = R.string.text_5,
            drawableRes = R.drawable.drawable_5
        ),
        ArticalScreen(
            tag = listOf(ArticleTag.NEWS, ArticleTag.ART),
            textRes = R.string.text_6,
            drawableRes = R.drawable.drawable_1
        ),
        ArticalScreen(
            tag = listOf(ArticleTag.POLITICAL, ArticleTag.MEDIA),
            textRes = R.string.text_7,
            drawableRes = R.drawable.drawable_7
        ),
        ArticalScreen(
            tag = listOf(ArticleTag.NEWS, ArticleTag.SPORT),
            textRes = R.string.text_8,
            drawableRes = R.drawable.drawable_8
        )
    )
val currentData = emptyArray<String>()



val filterData = arrayOf(true,true,true,true,true,true)



// fun filtredScreens(){
//    val adapter = Adapter(filteredArticles, this)
//    viewPager.adapter = adapter
//    dotsIndicator.setViewPager2(viewPager)
//}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        val adapter = Adapter(screens, this)
        viewPager.adapter = adapter
        dotsIndicator.setViewPager2(viewPager)

        viewPager.offscreenPageLimit = 1

        viewPager.setCurrentItem(2, false)
        viewPager.currentItem


        viewPager.setPageTransformer(PopTransformation())

        TabLayoutMediator(Tablayout, viewPager){
            tab, position  -> tab.text =
            when(position) {
                0 -> "Верховный суд..."
                1 -> "Бизнес не..."
                2 -> "Касперская..."
                3 -> "Сбербанк..."
                4 -> "Есть ли..."
                5 -> "Директор..."
                6 -> "Союз России..."
                else -> {"Мэтру - 80"}
            }
        }.attach()

        button.setOnClickListener {
            Tablayout.getTabAt((0 until 7).random())?.orCreateBadge?.apply {
                number = getNumber()+1
                badgeGravity = BadgeDrawable.BOTTOM_END
            }

        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Tablayout.getTabAt(position)?.removeBadge()
            }
        })

        button_filter.setOnClickListener {
            ChoiseDialogFragment.newInstance(filterData, screens).show(childFragmentManager, "choisedialogfragment ")
        }



    }

    companion object {
        fun newInstance(filter: Array<String>): ViewPagerFragment {

            val viewPager = ViewPagerFragment()
            val checkedArgs = Bundle()

            checkedArgs.putStringArray("tag", filter)

            viewPager.arguments = checkedArgs

            return viewPager

        }}


}