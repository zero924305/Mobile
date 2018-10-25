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

public class UserInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int coffeepoint = intent.getIntExtra("coffeepoint",-1);
        int totalCoffee = intent.getIntExtra("totalCoffee",-1);
        final String[] UsernameQR = new String[1];


        final TextView[] tvWelcomeMsg = {(TextView) findViewById(R.id.tvWelcomeMsg)};
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final Button showMessage = (Button)findViewById(R.id.MessageBtn);
        final Button clientCode = (Button) findViewById(R.id.clientCode);
        final ImageView UserQrcode = (ImageView) findViewById(R.id.UserQrcode);
        final TextView tvNcoffeepoint = (TextView) findViewById(R.id.tvNcoffeepoint);
        final TextView tvNtotalcoffee = (TextView) findViewById(R.id.tvNtotalcoffee);


        showMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent MessageIntent = new Intent(UserInterface.this, AllMessage.class);
                UserInterface.this.startActivity(MessageIntent);
            }
        });


        // Display user details
        String message = name + " welcome to your user area";
        tvWelcomeMsg[0].setText(message);
        etUsername.setText(username);
        tvNcoffeepoint.setText(coffeepoint + " ");
        tvNtotalcoffee.setText(totalCoffee + " ");


        clientCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsernameQR[0] = etUsername.getText().toString().trim();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try
                {
                    BitMatrix bitMatrix = multiFormatWriter.encode(UsernameQR[0], BarcodeFormat.QR_CODE,200,200);
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
