package com.colinbeuttler.dragonchronicles.models;

public class Egg {
    private boolean hatched;
    private int warmth;

    public Egg(boolean hatched, int warmth) {
        this.hatched = hatched;
        this.warmth = warmth;
    }

    public Egg(Egg source) {
        this.hatched = source.hatched;
        this.warmth = source.warmth;
    }

    public boolean isHatched() {
        if (this.warmth > 9) {
            setHatched(true);
        }
        return this.hatched;
    }

    public boolean getHatched() {
        return this.hatched;
    }

    public void setHatched(boolean hatched) {
        this.hatched = hatched;
    }

    public int getWarmth() {
        return this.warmth;
    }

    public void setWarmth(int warmth) {
        this.warmth = warmth;
    }

    public void increaseWarmth(int warmth) {
        this.warmth += warmth;
    }


    public void eggCare(String res) {
        switch (res) {
            case "a": {
                System.out.println(
                        "\n\tYou move closer the campfire cluthing the egg in your arms... it seems to warm up as you get closer, there was definately some movement from inside.");
                increaseWarmth(8);
                break;
            }
            case "b": {
                System.out.println(
                        "\n\tYou rub the egg back and forth with your hand... you think you saw movement but it was hard to tell...");
                increaseWarmth(3);
                break;
            }
            case "c": {
                System.out.println(
                        "\n\ta few moments elapse... you stare at the egg, maybe there was some faint movement, maybe there wasn't...");
                increaseWarmth(1);
                break;
            }
            default: {
                System.out.println("\n\tNothing happens");

            }
        }
    }

    public void careMessage() {
        System.out.println("\n\n\tWhat would you like to do with the Egg?");
        System.out.println("\n\ta) Hold the egg close to the fire.");
        System.out.println("\n\tb) Rub the egg.");
        System.out.println("\n\tc) Do nothing with the egg");
    }
}
