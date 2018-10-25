package com.example.altino.codereader;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        final EditText etTitle = (EditText) findViewById(R.id.etTitle);
        final EditText etMessage = (EditText) findViewById(R.id.etMessage);
        final Button UploadBtn = (Button) findViewById(R.id.UploadBtn);
        final Button HomeBtn = (Button) findViewById(R.id.HomeBtn);

        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent registerIntent = new Intent(MessageActivity.this, ReaderActivity.class);
                MessageActivity.this.startActivity(registerIntent);
            }
        });

        UploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = etTitle.getText().toString();
                final String message = etMessage.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MessageActivity.this);
                                builder.setMessage("Upload successful")
                                        .setNegativeButton("ok", null)
                                        .create()
                                        .show();
                                //Intent intent = new Intent(MessageActivity.this, ReaderActivity.class);
                                //MessageActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MessageActivity.this);
                                builder.setMessage("Upload Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                MessageRequest messageRequest = new MessageRequest(title, message, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MessageActivity.this);
                queue.add(messageRequest);
            }
        });
    }
}
