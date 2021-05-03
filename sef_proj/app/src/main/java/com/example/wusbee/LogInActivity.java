package com.example.wusbee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {
    private Button do_sign_in;
    private Button do_log_in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

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
                openSeeProfileActivity();
            }
        });
    }

    public void openSeeProfileActivity(){
        Intent intent = new Intent(this, SeeProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void openSignInActivity(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

}