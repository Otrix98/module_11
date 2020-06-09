package com.example.module_11

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

@SuppressLint("SupportAnnotationUsage")
data class ArticalScreen (
    @StringRes val tag: List<ArticleTag>,
    @StringRes val textRes: Int,
    @DrawableRes val drawableRes: Int
)