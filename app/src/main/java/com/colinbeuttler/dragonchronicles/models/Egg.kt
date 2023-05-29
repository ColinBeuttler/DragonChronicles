package com.colinbeuttler.dragonchronicles.models

class Egg(private var hatched: Boolean, var warmth: Int) {


    fun isHatched(): Boolean {
        if (warmth > 9) {
            setHatched(true)
        }
        return hatched
    }

    fun getHatched(): Boolean {
        return hatched
    }

    private fun setHatched(hatched: Boolean) {
        this.hatched = hatched
    }

    private fun increaseWarmth(warmth: Int) {
        this.warmth += warmth
    }

    fun eggCare(res: String?) {
        when (res) {
            "a" -> {
                println(
                    "\n\tYou move closer the campfire clutching the egg in your arms... it seems to warm up as you get closer, there was definitely some movement from inside."
                )
                increaseWarmth(8)
            }
            "b" -> {
                println(
                    "\n\tYou rub the egg back and forth with your hand... you think you saw movement but it was hard to tell..."
                )
                increaseWarmth(3)
            }
            "c" -> {
                println(
                    "\n\ta few moments elapse... you stare at the egg, maybe there was some faint movement, maybe there wasn't..."
                )
                increaseWarmth(1)
            }
            else -> {
                println("\n\tNothing happens")
            }
        }
    }

}