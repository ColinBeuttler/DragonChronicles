package com.colinbeuttler.dragonchronicles.models

class Materials(var primary: String, var secondary: String, specailty: String) {
    var specialty: String = specailty


    override fun toString(): String {
        return """
	Material List: 
${primary}
${secondary}
${specialty}"""
    }
}