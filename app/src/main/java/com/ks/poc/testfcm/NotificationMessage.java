package com.ks.poc.testfcm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_message);

        Intent intent = getIntent();
//        String msg = intent.getStringExtra("test");
        TextView tv = (TextView) findViewById(R.id.textView);
//        tv.setText(msg);
    }
}
