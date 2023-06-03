package com.colinbeuttler.dragonchronicles


import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.colinbeuttler.dragonchronicles.databinding.DialogFragmentBinding


class DialogFragment : Fragment() {

    private lateinit var binding: DialogFragmentBinding



//    private var dialogLine = (activity as GameActivity).getDialog()
//
//    private lateinit var options : Array<String>
//
//    private lateinit var optionAns : String

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



//        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_view_answer_option_layout, options)
//        binding.dialogOptionsListView.adapter = arrayAdapter
//
//
//        val builder = AlertDialog.Builder(requireActivity())
//        builder.setTitle(dialogLine[0])
//        builder.setItems(options) { _, which -> optionAns = options[which] }
//        val dialogOpt = builder.create()
//        if(dialogLine.size < 2){
//            dialogOpt.show()
//        }
//
//
//        Log.v(TAG, dialogLine[0])

    }



//    private fun optionsAns(ans: String?) {
//        Toast.makeText(getContext(), ans, Toast.LENGTH_LONG).show();
//        when (i) {
//            5 -> if (ans == "Yes") i += 2 else i++
//            8 -> {
//                when (ans) {
//                    "Green Egg" -> userDragon.type = Dragon.Type.BEHEMOTH
//                    "Blue Egg" -> userDragon.type = Dragon.Type.FAE
//                    "Purple Egg" -> userDragon.type = Dragon.Type.WYRM
//                }
//                i++
//            }
//            10 -> if (ans == "Yes") i++ else i -= 2
//            12 -> {
//                if (ans == "Hold the egg close to the fire.") ; else if (ans == "Rub the egg.") ; else if (ans == "Do nothing with the egg.");
//                i++
//            }
//            else -> i++
//        }
//    } //    private void saveGame() {
    //        Dragon userDragon = null;
    //        Context context = getActivity();
    //        assert context != null;
    //        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(userDragon), Context.MODE_PRIVATE);
    //
    //    }
}



