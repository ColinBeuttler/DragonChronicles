package com.colinbeuttler.dragonchronicles

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Transform

import com.colinbeuttler.dragonchronicles.databinding.GameActivityBackgroundBinding
import com.colinbeuttler.dragonchronicles.models.Dragon


private fun String.replace(string: Regex) {

}


class GameActivity : AppCompatActivity() {

    private lateinit var binding: GameActivityBackgroundBinding

    private var i = 0

    private var userDragon = Dragon(null, null, null)

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
        arrayOf("key:egg msg"),
        arrayOf("Choose this egg?", "Yes", "No"),
        arrayOf("You are handed the egg, you turn it over in your hands..."),
        arrayOf(
            "What would you like to do with the Egg?",
            "Hold the egg close to the fire.",
            "Rub the egg.",
            "Do nothing with the egg."
        ),
        arrayOf("I think it's hatching..."),
        arrayOf("Congratulations key:gender msg"),
        arrayOf("Ohhh, that's rare..."),
        arrayOf("a key:type msg"),
        arrayOf("Have you heard of the dragon tribes?", "Yes", "No"),
        arrayOf("Anyways... every dragon species has a place of origin..."),
        arrayOf("the locals in these places of origin tame and ride the respective species.."),
        arrayOf("so they know it better than anyone else."),
        arrayOf("These locals are known as the dragon tribes."),
        arrayOf("If you want to learn how to ride your new friend, you will need to seek out one of these tribes."),
        arrayOf(
            "The tribes you will want to seek out, is the key: origin msg tribe."
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = GameActivityBackgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.titleScreenBackgroundView.setOnClickListener { start() }
        binding.textViewDialogue.setOnClickListener { nextDialog() }

    }


    private fun start() {
        binding.textViewDialogue.visibility = View.VISIBLE
        binding.titleScreenBackgroundView.visibility = View.GONE
    }

    private fun nextDialog() {
        if (dialogLines[i].size > 2) {
            loadDialogBubble()

        } else {
            if(dialogLines[i][0].contains("key:", ignoreCase = true)) replaceString(dialogLines[i][0])
            binding.textViewDialogue.text = dialogLines[i][0]
            i++
        }
    }


    fun getDialog(): Array<String> {
        return dialogLines[i]
    }

    private fun loadDialogBubble() {
        val builder = AlertDialog.Builder(this)
        val ques = dialogLines[i][0].toString()
        val options: Array<String> = dialogLines[i].copyOfRange(1, dialogLines[i].size);
        builder.setTitle(ques)
        builder.setItems(options) { _, which -> optionAns(options[which]) }
        builder.create().show()


    }

    private fun optionAns(ans: String) {
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
            10 -> if (ans == "Yes") i++ else i -= 3
//            12 -> {
//                if (ans == "Hold the egg close to the fire.") ; else if (ans == "Rub the egg.") ; else if (ans == "Do nothing with the egg.");
//                i++
//            }
            else -> i++
        }
        binding.textViewDialogue.text = dialogLines[i][0]
    }


    private fun replaceString(str: String): String {
        if(str.contains("key:egg msg", ignoreCase = true)){
            Log.v(TAG, "key:egg msg")
            str.replace("key:egg msg", userDragon.eggMessage())
        }
        else if(str.contains("key:type msg", ignoreCase = true)){
            Log.v(TAG, "key:type msg")
            str.replace("key:type msg", userDragon.type.toString())
        }
        else if(str.contains("key:gender msg", ignoreCase = true)){
            Log.v(TAG, "key:gender msg")
            userDragon.genderMessage()?.let { str.replace("key:gender msg", it) }
        }
        else if(str.contains("key: origin msg", ignoreCase = true)){
            Log.v(TAG, "key: origin msg")
            str.replace("key: origin msg", userDragon.originMessage(userDragon))
        }

        return ""
    }

}

