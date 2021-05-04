package com.example.wusbee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {

    Button CreateAccButton;
    EditText FullName;
    EditText UserName;
    EditText Email;
    EditText PassWord;
    EditText PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        CreateAccButton = findViewById(R.id.create_acc_button);
        FullName = findViewById(R.id.full_name);
        UserName = findViewById(R.id.user_name);
        Email = findViewById(R.id.email);
        PassWord = findViewById(R.id.password);
        PhoneNumber = findViewById(R.id.phone_number);

        CreateAccButton.setOnClickListener(v -> { //add to db

            try {
                CustomerModel customerModel = new CustomerModel(
                        FullName.getText().toString(),
                        UserName.getText().toString(),
                        Email.getText().toString(),
                        PassWord.getText().toString(),
                        Integer.parseInt(PhoneNumber.getText().toString())
                );
            }catch(Exception exception){
                    Toast.makeText(this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                }

            Toast.makeText(this, "Successful Registration!", Toast.LENGTH_SHORT).show();

        });

    }
}