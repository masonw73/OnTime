package com.example.mason.ontime;

/**
 * Created by Mason on 10/15/16.
 */

public class userAccount {

    private String name;
    private String major;
    private String gradClass;
    private String residence;


    public userAccount(String name, String major, String gradClass, String residence) {

        this.name = name;
        this.major = major;
        this.gradClass = gradClass;
        this.residence = residence;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGradClass(String gradClass) {
        this.gradClass = gradClass;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getGradClass() {
        return gradClass;
    }

    public String getResidence() {
        return residence;
    }

}
