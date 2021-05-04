package com.example.wusbee;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
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

        CreateAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerModel customer;

                try {
                    customer = new CustomerModel(
                            FullName.getText().toString(),
                            UserName.getText().toString(),
                            Email.getText().toString(),
                            PassWord.getText().toString(),
                            Integer.parseInt(PhoneNumber.getText().toString()));

                    Toast.makeText(SignInActivity.this,"Successful Registration", Toast.LENGTH_SHORT).show();

                }catch(Exception exception) {
                    Toast.makeText(SignInActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                    customer = new CustomerModel("a", "a", "a", "a", 1);
                };

                DataBaseHandler dataBaseHandler = new DataBaseHandler(getApplicationContext());

                boolean success = dataBaseHandler.addCustomer(customer);
                Toast.makeText(SignInActivity.this, "Success = " + success , Toast.LENGTH_SHORT).show();
            }
        });
    }
}