package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextUsername=(EditText) findViewById(R.id.editTextUsername);
        mTextPassword=(EditText) findViewById(R.id.editTextPassword);
        mButtonLogin=(Button) findViewById(R.id.button_login);
        mTextViewRegister=(TextView) findViewById(R.id.registered);

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

    }
    public void openActivity(){
        Intent registerIntent= new Intent(this, RegisterActivity.class);
        startActivity(registerIntent);
    }
}
