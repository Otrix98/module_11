package com.example.module_11

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ChoiseDialogFragment(currentTags: List<ArticalScreen>): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val arrayChecked = booleanArrayOf(true,true,true,true,true,true)
        val tags = arrayOf(ArticleTag.NEWS.name, ArticleTag.SPORT.name, ArticleTag.POLITICAL.name, ArticleTag.ART.name, ArticleTag.IT.name, ArticleTag.MEDIA.name)
         return AlertDialog.Builder(requireContext())
            .setTitle("поиск по тегам")
            .setMultiChoiceItems(tags, arrayChecked, { dialog, which, isChecked ->
                arrayChecked[which] = isChecked
                val filteredArticles = tags[which]
            })
            .setPositiveButton("Применить", { _, _ ->

            })
            .setNegativeButton("Отмена", {_, _ ->  })
            .create()
    }
}