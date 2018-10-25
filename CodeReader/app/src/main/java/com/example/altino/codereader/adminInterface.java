package com.example.altino.codereader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_interface);

        Button ScanBtn = (Button) findViewById(R.id.ScanBtn);
        Button BtnMessage = (Button) findViewById(R.id.BtnMessage);

        ScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent registerIntent = new Intent(adminInterface.this, ReaderActivity.class);
                adminInterface.this.startActivity(registerIntent);
            }
        });
        BtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent registerIntent = new Intent(adminInterface.this,MessageActivity.class);
                adminInterface.this.startActivity(registerIntent);
            }
        });
    }
}
