package com.example.altino.coffeeclient;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRcode extends AppCompatActivity {

    Button ShowBtn;
    ImageView UserQrcode;
    TextView QRusername;
    String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        QRusername = (TextView) findViewById(R.id.QRusername);
        ShowBtn = (Button) findViewById(R.id.ShowBtn);
        UserQrcode = (ImageView) findViewById(R.id.UserQrcode);

        QRusername.setText(username);

        ShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username = QRusername.getText().toString().trim();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try
                {
                    BitMatrix bitMatrix = multiFormatWriter.encode(Username, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    UserQrcode.setImageBitmap(bitmap);
                }
                catch(WriterException e)
                {
                    e.printStackTrace();
                }
            }
        });


    }
}
