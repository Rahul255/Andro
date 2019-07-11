package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
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

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= mTextUsername.getText().toString().trim();
                String pwd= mTextPassword.getText().toString().trim();
                String cnf_pwd= mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText( RegisterActivity.this,"You have Registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    else {
                        Toast.makeText( RegisterActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText( RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void openActivity(){
        Intent LoginIntent= new Intent(this,MainActivity.class);
        startActivity(LoginIntent);
    }
}
