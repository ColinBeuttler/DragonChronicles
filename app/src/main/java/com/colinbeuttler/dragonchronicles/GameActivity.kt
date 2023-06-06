package com.colinbeuttler.dragonchronicles

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.colinbeuttler.dragonchronicles.databinding.GameActivityBackgroundBinding
import com.colinbeuttler.dragonchronicles.models.Dragon

class GameActivity : AppCompatActivity() {

    private lateinit var binding: GameActivityBackgroundBinding

    private var i = 0

    var userDragon = Dragon(null, null, null)

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
        arrayOf("Congratulations" + Dragon.determineGender()),
        arrayOf("Ohhh, that's rare..."),
        arrayOf("a " + userDragon.type),
        arrayOf("Have you heard of the dragon tribes?", "Yes", "No"),
        arrayOf("Anyways... every dragon species has a place of origin..."),
        arrayOf("the locals in these places of origin tame and ride the respective species.."),
        arrayOf("so they know it better than anyone else."),
        arrayOf("These locals are known as the dragon tribes."),
        arrayOf("If you want to learn how to ride your new friend, you will need to seek out one of these tribes."),
        arrayOf(
            "The tribes you will want to seek out, is the " + userDragon.originMessage(
                userDragon
            ) + " tribe."
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
        supportFragmentManager.commit { add(R.id.dialog_fragment, DialogFragment()) }
        binding.titleScreenBackgroundView.setOnClickListener { start() }
        binding.textViewDialogue.setOnClickListener { nextDialog() }
    }


    private fun start() {
        binding.textViewDialogue.visibility = View.VISIBLE
        binding.titleScreenBackgroundView.visibility = View.GONE
    }

    private fun nextDialog() {
//        if(dialogLines[i].size > 2){
//
//        }
        binding.textViewDialogue.text = dialogLines[i][0]
        i++
    }


    fun getDialog(): Array<String> {
        return dialogLines[i]
    }

}
