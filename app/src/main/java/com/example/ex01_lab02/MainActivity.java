package com.example.ex01_lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    CheckBox keep;
    Button reset,  sign;
    public boolean checkPassword(String s){
        String s1 = s;
        if (s.length() < 8){
            return false;
        }
        else if (s.toUpperCase().equals(s1)){
            return false;
        }
        else if (s.toLowerCase().equals(s1)){
            return false;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        keep = findViewById(R.id.Keep);
        reset = findViewById(R.id.Reset);
        sign = findViewById(R.id.Sign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.this.username.getText().toString().equals("")
                        || MainActivity.this.password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter username or password", Toast.LENGTH_SHORT).show();
                }
                else if (MainActivity.this.username.getText().toString().equals("admin")
                        && MainActivity.this.password.getText().toString().equals("admin1234")){
                    Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                }
                else if (!checkPassword(MainActivity.this.password.getText().toString())){
                    Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.this.username.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
                }
                else if(MainActivity.this.username.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Reset successfully", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}