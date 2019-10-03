package com.xiyu.test;

public class Hobby {
    private String hobbyName;
    private int level;

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Hobby() {
    }

    public Hobby(String hobbyName, int level) {
        this.hobbyName = hobbyName;
        this.level = level;
    }
}
