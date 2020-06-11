package com.example.module_11

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class ChoiseDialogFragment(): DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val arrayChecked = booleanArrayOf(true,true,true,true,true,true)
        arguments?.let {

            arrayChecked[0] = it.getBoolean(ArticleTag.NEWS.name)
            arrayChecked[1] = it.getBoolean(ArticleTag.SPORT.name)
            arrayChecked[2] = it.getBoolean(ArticleTag.POLITICAL.name)
            arrayChecked[3] = it.getBoolean(ArticleTag.ART.name)
            arrayChecked[4] = it.getBoolean(ArticleTag.IT.name)
            arrayChecked[5] = it.getBoolean(ArticleTag.MEDIA.name)
        }

        val currentTags = emptyArray<String>()
        val tags = arrayOf(ArticleTag.NEWS.name, ArticleTag.SPORT.name, ArticleTag.POLITICAL.name, ArticleTag.ART.name, ArticleTag.IT.name, ArticleTag.MEDIA.name)
         return AlertDialog.Builder(requireContext())
            .setTitle("поиск по тегам")
            .setMultiChoiceItems(tags, arrayChecked) { dialog, which, isChecked ->
                arrayChecked[which] = isChecked
                for (i in tags.indices) {

                    val checked = arrayChecked[i]
                    if (checked) {
                       currentTags.plus(tags[i])
                    }
                }
            }
            .setPositiveButton("Применить") { _, _ -> showViewPagerFragment(currentTags)}
             .setNegativeButton("Отмена") { _, _ ->  }
             .create()
    }

    fun showViewPagerFragment(tag: Array<String>){
        AppActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, ViewPagerFragment.newInstance(tag))
            .commit()
    }

    companion object {
        fun newInstance(filter: Array<Boolean>, currentTags: List<ArticalScreen>): DialogFragment {

            val tmp = ChoiseDialogFragment()
            val args = Bundle()

            args.putBoolean(ArticleTag.NEWS.name, filter[0])
            args.putBoolean(ArticleTag.SPORT.name, filter[1])
            args.putBoolean(ArticleTag.POLITICAL.name, filter[2])
            args.putBoolean(ArticleTag.ART.name, filter[3])
            args.putBoolean(ArticleTag.IT.name, filter[4])
            args.putBoolean(ArticleTag.MEDIA.name, filter[5])

            tmp.arguments = args

            return tmp

        }}
}