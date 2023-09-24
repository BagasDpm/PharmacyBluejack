package com.example.pharmacybluejack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText emailForm, passwordForm;

    Button buttonLogin, buttonGotoregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailForm = findViewById(R.id.emailForm);
        passwordForm = findViewById(R.id.passwordForm);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonGotoregis = findViewById(R.id.buttonGotoregis);

        buttonLogin.setOnClickListener(e ->{
            if(emailForm.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this, "Username required", Toast.LENGTH_SHORT).show();
                return;
            }
            if(passwordForm.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this, "Password required", Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                for (User user:RegisterActivity.dataUser) {
                    if(user.email.matches(emailForm.getText().toString()) && user.password.matches(passwordForm.getText().toString())) {
                        Intent moveToHome = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(moveToHome);
                        return;
                    }
                }
                Toast.makeText(LoginActivity.this, "Registrasi Dulu Gih!!!", Toast.LENGTH_SHORT).show();
                return;

            }
        });

        buttonGotoregis.setOnClickListener(e ->{
            Intent moveToRegis = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(moveToRegis);
        });

    }
}