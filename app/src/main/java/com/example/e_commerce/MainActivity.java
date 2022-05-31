package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {


    Intent homeIntent;
    Button Login;
    EditText Name;
    String NameText;

    public static final String NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeIntent = new Intent(this, Body_Page.class);
        Login = (Button) findViewById(R.id.Login_btn);

        Name = (EditText) findViewById(R.id.Name);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeIntent = new Intent(MainActivity.this, Body_Page.class);
                NameText = Name.getText().toString();
                homeIntent.putExtra("NAME", NameText);

                startActivity(homeIntent);
            }
        });

    }



}