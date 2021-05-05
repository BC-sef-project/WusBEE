package com.example.wusbee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wusbee.db.CustomerDatabase;
import com.example.wusbee.db.CustomerModel;


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

                addCustomerToDb(FullName.getText().toString(),
                        UserName.getText().toString(),
                        Email.getText().toString(),
                        PassWord.getText().toString(),
                        PhoneNumber.getText().toString());
            }
        });
    }

    private void addCustomerToDb(String name, String user, String email, String pass, String phone) {
        CustomerModel customer = new CustomerModel(name, user, email, pass, phone);

        CustomerDatabase db = CustomerDatabase.getDbInstance(this.getApplicationContext());
        db.customerDao().insertCustomer(customer);
        Toast.makeText(this.getApplicationContext(), "Account created successful!", Toast.LENGTH_SHORT).show();
    }
}