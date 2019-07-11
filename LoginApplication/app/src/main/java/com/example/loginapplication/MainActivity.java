package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
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
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if(res == true){
                    Toast.makeText( MainActivity.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText( MainActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void openActivity(){
        Intent registerIntent= new Intent(this, RegisterActivity.class);
        startActivity(registerIntent);
    }
}
