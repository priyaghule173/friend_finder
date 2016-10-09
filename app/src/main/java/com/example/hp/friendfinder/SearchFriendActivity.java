package com.example.hp.friendfinder;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hp on 18/9/16.
 */
public class SearchFriendActivity extends Activity {
    Button searchbutton, messagebutton, Callbutton;
    public String tagstring = "";
    public String phoneno;
    private final static String tag = "SEARCHED TAG";
    public TextView searchName, searchPhoneNo;
    public Spinner searchtag;
    FriendsManager manager;
    ArrayList<Friend> friends;
    //  Intent sendmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friend);
        searchbutton = (Button) findViewById(R.id.searchbutton);
        messagebutton = (Button) findViewById(R.id.smsbutton);
        Callbutton = (Button) findViewById(R.id.callbutton);
        manager = FriendsManager.getInstance();
        friends = manager.getFriends();

        searchbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                messagebutton.setVisibility(View.VISIBLE);
                Callbutton.setVisibility(View.VISIBLE);
                addtagtoString(view);
            }
        });


    }

    public void addtagtoString(View view) {
        searchtag = (Spinner) findViewById(R.id.nameoftag);
        tagstring = searchtag.getSelectedItem().toString();

        try {

            for (int i = 0; i < friends.size(); i++) {

                if (tagstring.equals(friends.get(i).getTag())) {

                    phoneno = friends.get(i).getMobileNumber();
                    Toast.makeText(this, "Tag Found" + friends.get(i).getName() + " " + tagstring, Toast.LENGTH_SHORT).show();
                    Log.d(tag, "Found i =" + friends.get(i).getName() + friends.get(i).getMobileNumber());
                } else {
                    Toast.makeText(this, "Tag Not Found" + friends.get(i).getName() + " " + tagstring, Toast.LENGTH_SHORT).show();
                    Log.d(tag, "No Match Found For i = " + i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // sendmessage = new Intent(SearchFriendActivity.this, SmsActivity.class);
        // startActivity(sendmessage);

    }


    public void sendSMS(View view) {


        Log.d(tag, "sendSMS: " + phoneno);
        Intent sendsmsintent = new Intent();
        sendsmsintent.setAction(Intent.ACTION_VIEW);
        sendsmsintent.setData(Uri.parse("smsto:" + phoneno));
        if (sendsmsintent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendsmsintent);
        } else {
            Toast.makeText(this, " Application Not Found ", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(SearchFriendActivity.this, "TODO Open SMS App", Toast.LENGTH_SHORT).show();

    }

    public void Callfriend(View view) {
        Intent sendcallintent = new Intent();
        sendcallintent.setAction(Intent.ACTION_DIAL);//Uri.parse("Call To:"  + phoneno));
        sendcallintent.setData(Uri.parse("tel:" + phoneno));
        if (sendcallintent.resolveActivity(getPackageManager()) != null) {
            Log.d(tag, "Call to: " + phoneno);
            startActivity(sendcallintent);
        } else {
            Toast.makeText(this, " Application Not Found ", Toast.LENGTH_SHORT).show();
        }
    }

}
