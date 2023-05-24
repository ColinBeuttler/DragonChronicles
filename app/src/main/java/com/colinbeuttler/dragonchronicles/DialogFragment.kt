package com.colinbeuttler.dragonchronicles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
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
    private var dialogLines = arrayOf(
        arrayOf("Good Morning"),
        arrayOf("Finally awake I see...."),
        arrayOf("Now where were we?"),
        arrayOf("...Oh yes that's right!!!"),
        arrayOf("You were about to pick a dragon egg..."),
        arrayOf("Did you make a decision yet?", "Yes", "No"),
        arrayOf("Need more time..."),
        arrayOf("or Should I pick for you?", "Green Egg", "Blue Egg", "Purple Egg"),
        arrayOf("You stare deep into the egg..."),
        arrayOf(userDragon.eggMessage()),
        arrayOf("Choose this egg?", "Yes", "No"),
        arrayOf("You are handed the egg, you turn it over in your hands..."),
        arrayOf(
            "What would you like to do with the Egg?",
            "Hold the egg close to the fire.",
            "Rub the egg.",
            "Do nothing with the egg."
        ),
        arrayOf("I think it's hatching..."),
        arrayOf("Congratulations" + determineGender()),
        arrayOf("Ohhh, that's rare..."),
        arrayOf("a " + userDragon.type),
        arrayOf("Have you heard of the dragon tribes?", "Yes", "No"),
        arrayOf("Anyways... every dragon species has a place of origin..."),
        arrayOf("the locals in these places of origin tame and ride the respective species.."),
        arrayOf("so they know it better than anyone else."),
        arrayOf("These locals are known as the dragon tribes."),
        arrayOf("If you want to learn how to ride your new friend, you will need to seek out one of these tribes."),
        arrayOf(
            "The tribes you will want to seek out, is the " + userDragon.originMessage(userDragon) + " tribe."
        ),
        arrayOf("Quite a wild bunch if I remember, although I'd say that about all the dragon tribes..."),
        arrayOf("there's a reason I just sell their eggs, I'm not crazy enough to actually get on one's back..."),
        arrayOf("This is when we part ways, are you ready to go?", "Yes", "Not yet"),
        arrayOf("...well you can't stay here with me, I have business to attend."),
        arrayOf("Ready to be on your way?", "Yes", "No"),
        arrayOf("A small carriage drops from above you, several adolescent wyverns are tethered to the top."),
        arrayOf("The door swings open, revealing a black barren interior with a single seat, it has no windows"),
        arrayOf("With your new Hatchling in toe, you get inside..."),
        arrayOf("Continue to next Chapter?")
    )

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

        binding.textViewDialogue.setOnClickListener(View.OnClickListener { v: View? ->
            if (dialogLines[i].size < 2) {
                binding.textViewDialogue.text = dialogLines[i][0]
                i++
            } else if (dialogLines[i].size > 1) {
                addDialogOptions()
            }
        })
    }

    //    public String getLine() {
    //        if (dialogLines[i].length > 1) {
    //            addDialogOptions();
    //        }
    //        Toast.makeText(getContext(), "option" + dialogLines[i][0], Toast.LENGTH_SHORT).show();
    //        return dialogLines[i][0];
    //    }
    private fun addDialogOptions() {
        options = ArrayList()
        options.addAll(listOf(*dialogLines[i]).subList(1, dialogLines[i].size))
        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.list_view_answer_option_layout, options)
        binding.dialogOptionsListView.adapter = arrayAdapter
        binding.dialogOptionsListView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val value = arrayAdapter.getItem(position)
                //                Toast.makeText(getContext(), value, Toast.LENGTH_LONG).show();
                optionsAns(value)
            }
    }

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