package com.example.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity_newAccount extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editPhone, editEmail, editUsername, editPassword;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_new_account);
        myDb=new DatabaseHelper(this);


        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnAddData = findViewById(R.id.button_submit);

        AddData();

    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editPhone.getText().toString(), editEmail.getText().toString(),
                                editUsername.getText().toString(), editPassword.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(Main2Activity_newAccount.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main2Activity_newAccount.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
