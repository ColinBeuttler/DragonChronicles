package com.colinbeuttler.dragonchronicles

import com.colinbeuttler.dragonchronicles.models.Dragon

object GameData {

    var options: Array<String> = addOptions() as Array<String>

    var userDragon = Dragon(null, null, null)

    var optionAns: String? = null

    var i = 0

    var dialogLines = arrayOf(
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

    private fun addOptions(): List<String> {
        if(dialogLines[i].size > 1){
            return (dialogLines[i].drop(0))
        }
      return emptyList()
    }

    public fun addInt(int: Int){
        i += int
    }

    public fun getDialog(int: Int): Array<String> {
        return dialogLines[int]
    }


}