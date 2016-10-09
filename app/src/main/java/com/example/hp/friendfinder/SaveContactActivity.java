
package com.example.hp.friendfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hp on 31/8/16.
 */
public class SaveContactActivity extends Activity {

    private TextView tvName, tvPhoneNumber, tvTag;
    private String name;
    private String phonenumber;
    private String tag;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return ;
        }


        name = getIntent().getStringExtra("person_name");
        phonenumber = getIntent().getStringExtra("phone_number");
        tag = getIntent().getStringExtra("Tag");

        initUi();

    }

    private void initUi() {
        tvName = (TextView) findViewById(R.id.name);
        tvPhoneNumber = (TextView) findViewById(R.id.phone);
        tvTag = (TextView) findViewById(R.id.tag);
        tvName.setText(name);
        tvPhoneNumber.setText(phonenumber);
        tvTag.setText(tag);


    }

    public void close(View view) {
        finish();
    }

}