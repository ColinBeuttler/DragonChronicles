package com.colinbeuttler.dragonchronicles

import android.R
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import org.jetbrains.annotations.Nullable


class OptionAlert : DialogFragment() {

    fun newInstance(title: Int): OptionAlert? {
        val frag = OptionAlert()
        val args = Bundle()
        args.putInt("title", title)
        frag.arguments = args
        return frag
    }

    fun onCreateDialog(@Nullable savedInstanceState: Bundle?): Unit? {
        return activity?.let {
            val title = "title"
            AlertDialog.Builder(it)
                .setTitle(title)
                .create().show()
        }
    }
}