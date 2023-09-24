package com.example.pharmacybluejack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    public static boolean validatePass (String x){
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
        Pattern cek = Pattern.compile(regex);
        if(x==null){
            return false;
        }
        Matcher validate = cek.matcher(x);
        return validate.matches();
    }

    public static ArrayList<User> dataUser = new ArrayList<>();

    EditText usernameForm, emailForm, passwordForm, confirmPasswordForm, phoneNumber;
    Button buttonRegis, buttonGotologin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameForm = findViewById(R.id.usernameForm);
        emailForm = findViewById(R.id.emailForm);
        passwordForm = findViewById(R.id.passwordForm);
        confirmPasswordForm = findViewById(R.id.confirmPasswordForm);
        phoneNumber = findViewById(R.id.phoneNumberForm);

        buttonRegis = findViewById(R.id.buttonRegis);
        buttonRegis.setOnClickListener(e-> {
            String username = usernameForm.getText().toString();
            String email = emailForm.getText().toString();
            String password = passwordForm.getText().toString();
            String conpassword = confirmPasswordForm.getText().toString();
            String phone = phoneNumber.getText().toString();
            String emailValidate = "[a-zA-Z0-9._-]+.com";

            if(username.isEmpty()){
                Toast.makeText(RegisterActivity.this, "Username can not be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(email.isEmpty()){
                Toast.makeText(RegisterActivity.this, "email can not be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty()){
                Toast.makeText(RegisterActivity.this, "Password can not be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (conpassword.isEmpty()){
                Toast.makeText(RegisterActivity.this, "Confirm Password can not be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (phone.isEmpty()){
                Toast.makeText(RegisterActivity.this, "Phone Number can not be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (username.length() < 5) {
                Toast.makeText(RegisterActivity.this, "Invalid Username (at least 5 characters)", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!email.matches(emailValidate)) {
                Toast.makeText(RegisterActivity.this, "Invalid Email (must end with '.com')", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!validatePass(passwordForm.getText().toString())) {
                Toast.makeText(RegisterActivity.this,"Invalid Password (must be alphanumeric)", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.equals(conpassword)){
                Toast.makeText(RegisterActivity.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                return;
            }

            User.Insert(new User((User.id)+1, username, email, password, phone));
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            Toast.makeText(RegisterActivity.this, "Register success", Toast.LENGTH_SHORT).show();
        });

        buttonGotologin = findViewById(R.id.buttonGotologin);
        buttonGotologin.setOnClickListener(e-> {
            Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(moveToLogin);
        });
    }
}