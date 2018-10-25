package com.example.altino.coffeeclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        TextView tvMessage = (TextView) findViewById(R.id.tvMessage);

        String title = "Title: " + tvTitle;
        String Message = " " + tvMessage;
        tvTitle.setText(title);
        tvMessage.setText(Message);

    }
}
