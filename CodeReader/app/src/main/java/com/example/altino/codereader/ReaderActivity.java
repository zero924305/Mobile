package com.example.altino.codereader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ReaderActivity extends AppCompatActivity {
    private Button scanBtn;
    private Button HomeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        scanBtn = (Button) findViewById(R.id.scanBtn);
        HomeBtn = (Button) findViewById(R.id.HomeBtn);

        //back to home page
        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent registerIntent = new Intent(ReaderActivity.this,adminInterface.class);
                ReaderActivity.this.startActivity(registerIntent);
            }
        });

        final Activity activity = this;
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBeepEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null)
        {
            if(result.getContents()==null)
            {
                Toast.makeText(this,"You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else
            {
               Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }


}
