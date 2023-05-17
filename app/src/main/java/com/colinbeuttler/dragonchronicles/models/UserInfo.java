package com.colinbeuttler.dragonchronicles.models;

public class UserInfo {

    private Dragon userDragon;
    private int currentChapter;

    public UserInfo( Dragon userDragon, int currentChapter) {

        this.userDragon = userDragon;
        this.currentChapter = currentChapter;
    }


    public Dragon getUserDragon() {
        return userDragon;
    }

    public void setUserDragon(Dragon userDragon) {
        this.userDragon = userDragon;
    }

    public int getCurrentChapter() {
        return currentChapter;
    }

    public void setCurrentChapter(int currentChapter) {
        this.currentChapter = currentChapter;
    }
}
