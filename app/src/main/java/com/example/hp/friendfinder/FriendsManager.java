package com.example.hp.friendfinder;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by hp on 3/9/16.
 */
public class FriendsManager {

    private static FriendsManager friendsManagerSingleton = null;
    private static int index = 0;
    public ArrayList<Friend> friends = new ArrayList<>();
    public static final String tag = "Came";

    public FriendsManager() {
        // private constructor
        friends = new ArrayList<>();

    }

    public static synchronized FriendsManager getInstance() {
        if (friendsManagerSingleton == null) {
            friendsManagerSingleton = new FriendsManager();
        }

        return friendsManagerSingleton;

    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    public boolean addFriend(Friend friend) {
        friends.add(index++, friend);
        return true;

    }

    public boolean getObjectdetails() {
        for (int i = 0; i < friends.size(); i++) {
            Log.d(tag, friends.get(i).getName());
        }
        return true;
    }

    public boolean removeFriend(String name) {
        //this.friends.remove(name);
        return false;
    }

}
