package com.colinbeuttler.dragonchronicles.models

import kotlin.math.roundToInt

class Dragon(var name: String, var type: Type, var gender: Gender) {
    enum class Gender {
        MALE, FEMALE
    }

    enum class Type {
        BEHEMOTH, WYRM, FAE
    }


    fun eggMessage(): String? {
        var message: String? = null
        message = when (type) {
            Type.FAE -> {
                "...within the egg, you sense both calm and ferocity. A brilliant interior with veiled edges constantly moving like a swirling typhoon."
            }
            Type.BEHEMOTH -> {
                "...within the egg's great deeps you sense a cold fathomless light, akin to the endless depths of the tunnels dug by the Deep Mountain Dwellers."
            }
            Type.WYRM -> {
                "...within the egg, you see a radiant glow dancing within, both fast and graceful."
            }
        }
        return message
    }

    fun genderMessage(): String? {
        var message: String? = null
        if (gender == Gender.MALE) {
            message = "It's a boy"
        } else if (gender == Gender.FEMALE) {
            message = "It's a girl"
        }
        return message
    }

    fun keepersMessage(dragon: Dragon): String? {
        var message: String? = null
        message = when (dragon.type) {
            Type.FAE -> {
                "Anglers"
            }
            Type.BEHEMOTH -> {
                "Deep Water Dwellers"
            }
            Type.WYRM -> {
                "Cyber Children"
            }
        }
        return message
    }

    fun originMessage(dragon: Dragon): String? {
        var message: String? = null
        message = when (dragon.type) {
            Type.FAE -> {
                "Windy Islands"
            }
            Type.BEHEMOTH -> {
                "Deep Water Caves"
            }
            Type.WYRM -> {
                "Sky Fortress"
            }
        }
        return message
    }


    companion object {
        @JvmStatic
        fun determineGender(): Gender {
            val gender = Math.random().roundToInt().toInt()
            return if (gender < 1) {
                Gender.FEMALE
            } else {
                Gender.MALE
            }
        }
    }
}