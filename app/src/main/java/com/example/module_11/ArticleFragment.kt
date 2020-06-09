package com.example.module_11

import android.os.Bundle
import android.provider.Settings.Global.putInt
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment(): Fragment(R.layout.fragment_article) {



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView.setText(requireArguments().getInt(KEY_TEXT))
        imageView.setImageResource(requireArguments().getInt(KEY_IMAGE))
    }



    companion object {
        private const val KEY_TEXT = "text"
        private const val KEY_IMAGE = "image"


        fun newInstance(
            @StringRes textRes: Int,
            @DrawableRes drawableRes: Int
        ): ArticleFragment {
            return ArticleFragment().whithArguments {
                putInt(KEY_TEXT, textRes)
                putInt(KEY_IMAGE, drawableRes)

            }

        }

    }


}