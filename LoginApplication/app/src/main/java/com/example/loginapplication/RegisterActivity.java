package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextUsername=findViewById(R.id.editTextUsername);
        mTextPassword=findViewById(R.id.editTextPassword);
        mTextCnfPassword=findViewById(R.id.editTextCnfPassword);
        mButtonRegister=findViewById(R.id.button_login);
        mTextViewLogin=findViewById(R.id.text_view_login);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent LoginIntent= new Intent(this,MainActivity.class);
        startActivity(LoginIntent);
    }
}
