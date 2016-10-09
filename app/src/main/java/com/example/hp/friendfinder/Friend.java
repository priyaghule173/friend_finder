package com.example.hp.friendfinder;

/**
 * Created by hp on 3/9/16.
 */
public class Friend {

    private String name;
    private String mobileNumber;
    private String tag;

    public Friend(String name, String mobileNumber, String tag) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
