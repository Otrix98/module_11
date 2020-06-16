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

    private fun applyFilter(viewpager: ViewPager2, screens : List<ArticalScreen>) {
        val adapter = Adapter(screens, this)
        viewpager.adapter = adapter
        TabLayoutMediator(Tablayout, viewPager) { tab, position ->
            tab.text = "Вкладка ${position + 1}"
        }.attach()
        dotsIndicator.setViewPager2(viewPager)
    }



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

    private var filtredArticles = screens


    fun onConfirm(filteredData : Array<Boolean>) {

        val tmpModelList = ArrayList<ArticalScreen>()

        for (e in screens)
        {

            if ((filteredData[0] && e.tag.contains(ArticleTag.NEWS)) ||
                (filteredData[1] && e.tag.contains(ArticleTag.SPORT)) ||
                (filteredData[2] && e.tag.contains(ArticleTag.POLITICAL)) ||
                (filteredData[3] && e.tag.contains(ArticleTag.ART)) ||
                (filteredData[4] && e.tag.contains(ArticleTag.IT)) ||
                (filteredData[5] && e.tag.contains(ArticleTag.MEDIA))) {

                tmpModelList.add(e)
            }
        }
        filterData = filteredData
        applyFilter(viewPager, tmpModelList)
    }





    var filterData = arrayOf(true,true,true,true,true,true)



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        button.setOnClickListener {
            Tablayout.getTabAt((0 until 7).random())?.orCreateBadge?.apply {
                number = getNumber()+1
                badgeGravity = BadgeDrawable.BOTTOM_END
            }
        }

        filterData = arrayOf(true,true,true,true,true,true)
        setHasOptionsMenu(true)
        applyFilter(viewPager, screens)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Tablayout.getTabAt(position)?.removeBadge()
            }
        })

        button_filter.setOnClickListener {
            ChoiseDialogFragment.newInstance(filterData).show(childFragmentManager, "choisedialogfragment ")
        }

    }

}