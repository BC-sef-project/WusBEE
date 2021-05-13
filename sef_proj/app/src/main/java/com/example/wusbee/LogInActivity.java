package com.example.wusbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wusbee.db.CustomerDao;
import com.example.wusbee.db.CustomerDatabase;


public class LogInActivity extends AppCompatActivity {
    private Button do_sign_in;
    private Button do_log_in;

    private EditText userName;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userName = findViewById(R.id.user_text);
        passWord = findViewById(R.id.pass_text);

        do_sign_in = findViewById(R.id.sign_in);
        do_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignInActivity();
            }
        });

        do_log_in = findViewById(R.id.log_in_button);
        do_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_text = userName.getText().toString();
                String pass_text = passWord.getText().toString();

                EncryptDecrypt ed = new EncryptDecrypt();
                try {
                    pass_text = ed.encrypt(user_text, pass_text);
                }catch (Exception e){
                    e.printStackTrace();
                }

                handleRegistration(user_text, pass_text);
            }
        });
    }

    public void openSeeProfileActivity(){
        Intent intent = new Intent(LogInActivity.this, SeeProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void openSignInActivity(){
        Intent intent = new Intent(LogInActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    private void handleRegistration(String user_text, String pass_text){

        CustomerDatabase db = CustomerDatabase.getDbInstance(this.getApplicationContext());
        final CustomerDao customerDao = db.customerDao();
        boolean customerModelCheck;

        customerModelCheck = customerDao.logInCustomer(user_text, pass_text);
        if (customerModelCheck){
            openSeeProfileActivity();
        }else{
            Toast.makeText(LogInActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
        }
    }

}