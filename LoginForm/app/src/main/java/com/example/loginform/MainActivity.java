package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.btnlogin);
        username=findViewById(R.id.txtuser);
        password=findViewById(R.id.txtpass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });

    }

    public void login(){
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("rahul")&& pass.equals("rahul")){
            Toast.makeText(this,"username and password match",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"username and password do not match",Toast.LENGTH_LONG).show();
        }

    }
}
