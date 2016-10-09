package com.example.hp.friendfinder;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hp on 18/9/16.
 */
public class CallActivity extends Activity {

    private static String TAG = "CallActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_call);

    }

}
