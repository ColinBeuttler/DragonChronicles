package com.colinbeuttler.dragonchronicles.models;

public class UserInfo {

    private String userName;
    private String password;

    private Dragon userDragon;
    private int currentChapter;

    public UserInfo(String userName, String password, Dragon userDragon, int currentChapter) {
        this.userName = userName;
        this.password = password;
        this.userDragon = userDragon;
        this.currentChapter = currentChapter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
