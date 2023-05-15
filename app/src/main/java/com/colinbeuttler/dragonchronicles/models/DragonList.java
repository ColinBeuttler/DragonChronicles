package com.colinbeuttler.dragonchronicles.models;

import java.util.ArrayList;

public class DragonList {
    private ArrayList<Dragon> dragons;

    public void DragonsList() {
        this.dragons = new ArrayList<Dragon>();
    }

    public Dragon getDragon(int index) {
        return new Dragon(this.dragons.get(index));
    }

    public void setDragon(int index, Dragon dragon) {
        this.dragons.set(index, new Dragon(dragon));
    }

    public void addDragon(Dragon dragon) {
        if (this.dragons.contains(dragon)) {
            return;
        }
        this.dragons.add(new Dragon(dragon));
    }

    public int assignDragon() {
        double ranDragon = Math.random() * dragons.size();
        return (int) ranDragon;
    }


    public String toString(int index) {
        return dragons.get(index).toString();
    }
}
