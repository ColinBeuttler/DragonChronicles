package com.colinbeuttler.dragonchronicles

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.VIEW_LOG_TAG
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.colinbeuttler.dragonchronicles.databinding.DialogFragmentBinding
import com.colinbeuttler.dragonchronicles.models.Dragon
import com.colinbeuttler.dragonchronicles.models.Dragon.Companion.determineGender
import java.util.*
import kotlin.collections.ArrayList

class DialogFragment : Fragment() {

    private lateinit var binding: DialogFragmentBinding

    private lateinit var options: ArrayList<String>

    var userDragon = Dragon(null, null, null)
    var i = 0



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dialog : Array<String> = (activity as GameActivity).getDialog()

        Log.v(TAG, dialog[0])

//        binding.textViewDialogue.setOnClickListener(View.OnClickListener { v: View? ->
//            if (dialogLine.size < 2) {
//                binding.textViewDialogue.text = dialogLine[0]
//                i++
//            } else if (dialogLine.size > 1) {
//                addDialogOptions()
//            }
//        })
    }

    //    public String getLine() {
    //        if (dialogLines[i].length > 1) {
    //            addDialogOptions();
    //        }
    //        Toast.makeText(getContext(), "option" + dialogLines[i][0], Toast.LENGTH_SHORT).show();
    //        return dialogLines[i][0];
    //    }
//    private fun addDialogOptions() {
//        options = ArrayList()
//        options.addAll(listOf(*dialogLine).subList(1, dialogLine.size))
//        val arrayAdapter =
//            ArrayAdapter(requireContext(), R.layout.list_view_answer_option_layout, options)
//        binding.dialogOptionsListView.adapter = arrayAdapter
//        binding.dialogOptionsListView.onItemClickListener =
//            OnItemClickListener { parent, view, position, id ->
//                val value = arrayAdapter.getItem(position)
//                //                Toast.makeText(getContext(), value, Toast.LENGTH_LONG).show();
//                optionsAns(value)
//            }
//    }

    private fun optionsAns(ans: String?) {
//        Toast.makeText(getContext(), ans, Toast.LENGTH_LONG).show();
        when (i) {
            5 -> if (ans == "Yes") i += 2 else i++
            8 -> {
                when (ans) {
                    "Green Egg" -> userDragon.type = Dragon.Type.BEHEMOTH
                    "Blue Egg" -> userDragon.type = Dragon.Type.FAE
                    "Purple Egg" -> userDragon.type = Dragon.Type.WYRM
                }
                i++
            }
            10 -> if (ans == "Yes") i++ else i -= 2
//            12 -> {
//                if (ans == "Hold the egg close to the fire.") ; else if (ans == "Rub the egg.") ; else if (ans == "Do nothing with the egg.");
//                i++
//            }
            else -> i++
        }
    } //    private void saveGame() {
    //        Dragon userDragon = null;
    //        Context context = getActivity();
    //        assert context != null;
    //        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(userDragon), Context.MODE_PRIVATE);
    //
    //    }
}