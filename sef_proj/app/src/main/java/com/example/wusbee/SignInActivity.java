package com.example.wusbee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wusbee.db.CustomerDao;
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

                String name = FullName.getText().toString();
                String user = UserName.getText().toString();
                String email = Email.getText().toString();
                String password = PassWord.getText().toString();
                String phone = PhoneNumber.getText().toString();

                CustomerModel customer = new CustomerModel(name, user, password, email, phone);

                if(customerFieldsAreFull(customer)){

                    if(customerNotFoundInDB(customer.getUsername())) {
                        addCustomerToDb(customer);
                    }else{
                        Toast.makeText(SignInActivity.this, "Account already exists!" +
                                "Choose another username!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignInActivity.this, "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addCustomerToDb(CustomerModel customerModel) {
        CustomerDatabase db = CustomerDatabase.getDbInstance(this.getApplicationContext());
        db.customerDao().insertCustomer(customerModel);
        Toast.makeText(this.getApplicationContext(), "Account created successfully!", Toast.LENGTH_SHORT).show();
    }

    private boolean customerFieldsAreFull(CustomerModel customerModel){

        if (customerModel.getFullname().isEmpty() ||
            customerModel.getUsername().isEmpty() ||
            customerModel.getEMail().isEmpty() ||
            customerModel.getPassword().isEmpty() ||
            customerModel.getPhone_number().isEmpty())
        return false;

        return true;
    }

    private boolean customerNotFoundInDB(String username) {
        CustomerDatabase db = CustomerDatabase.getDbInstance(this.getApplicationContext());

        if(db.customerDao().checkIfCustomerExists(username))
            return false;

        return true;
    }

}