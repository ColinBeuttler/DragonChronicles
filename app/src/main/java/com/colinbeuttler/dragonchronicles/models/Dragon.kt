package com.colinbeuttler.dragonchronicles.models;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Dragon {

    public enum Gender {
        MALE, FEMALE
    }

    public enum Type {
        BEHEMOTH, WYRM, FAE
    }

    public String name;
    private Type type;
    private Gender gender;


    public Dragon(String name, Type type, Gender gender) {

        this.name = name;
        this.type = type;
        this.gender = gender;
    }

    public Dragon(Dragon source) {
        this.name = source.name;
        this.type = source.type;
        this.gender = source.gender;
    }


    public Type getType() {
        return type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public static Gender determineGender() {
        int gender = (int) Math.round(Math.random());
        if (gender < 1) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    public String eggMessage() {
        String message = null;
        if (this.getType() == Type.FAE) {
            message = "...within the egg, you sense both calm and ferocity. A brilliant interior with veiled edges constantly moving like a swirling typhoon.";
        } else if (this.getType() == Type.BEHEMOTH) {
            message = "...within the egg's great deeps you sense a cold fathomless light, akin to the endless depths of the tunnels dug by the Deep Mountain Dwellers.";
        } else if (this.getType() == Type.WYRM) {
            message = "...within the egg, you see a radiant glow dancing within, both fast and graceful.";
        }
        return message;
    }

    ;

    public String genderMessage() {
        String message = null;
        if (this.gender.equals(Gender.MALE)) {
            message = "It's a boy";
        } else if (this.gender.equals(Gender.FEMALE)) {
            message = "It's a girl";
        }
        return message;
    }

    public String keepersMessage(Dragon dragon) {
        String message = null;
        if (dragon.getType() == Type.FAE) {
            message = "Anglers";
        } else if (dragon.getType() == Type.BEHEMOTH) {
            message = "Deep Water Dwellers";
        } else if (dragon.getType() == Type.WYRM) {
            message = "Cyber Children";
        }
        return message;
    }

    public String originMessage(Dragon dragon) {
        String message = null;
        if (dragon.getType() == Type.FAE) {
            message = "Windy Islands";
        } else if (dragon.getType() == Type.BEHEMOTH) {
            message = "Deep Water Caves";
        } else if (dragon.getType() == Type.WYRM) {
            message = "Sky Fortress";
        }
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Dragon)) {
            return false;
        }
        Dragon dragon = (Dragon) obj;
        return Objects.equals(type, dragon.type)
                && Objects.equals(gender, dragon.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, gender);
    }

    @NonNull
    public String toString() {
        return "\n\tLooks like it's something called a " + getType() + "\n";
    }

}
