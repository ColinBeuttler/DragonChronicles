package com.colinbeuttler.dragonchronicles.models;

import androidx.annotation.NonNull;

public class Materials {

    private String primary;
    private String secondary;
    private String specialty;


    public Materials(String primary, String secondary, String specailty) {
        this.primary = primary;
        this.secondary = secondary;
        this.specialty = specailty;
    }

    public Materials(Materials source) {
        this.primary = source.primary;
        this.secondary = source.secondary;
        this.specialty = source.specialty;
    }


    public String getPrimary() {
        return this.primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getSecondary() {
        return this.secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @NonNull
    public String toString() {
        return "\n\tMaterial List: \n" + this.primary + "\n" + this.secondary + "\n" + this.specialty;
    }
}
