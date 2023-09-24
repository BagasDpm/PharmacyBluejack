package com.example.pharmacybluejack;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeActivity extends FragmentActivity {

    BottomNavigationView navView;
    HomeFragment homeFragment = new HomeFragment();
    TransactionFragment transactionFragment = new TransactionFragment();
    AboutusFragment aboutusFragment = new AboutusFragment();
    TextView titleHeader;
    ImageView logo;
    ImageButton logoutBtn;

    public static ArrayList<Trans>transacArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(new HomeFragment());

        titleHeader = findViewById(R.id.titleheader);
        logo = findViewById(R.id.logo);

        logoutBtn = findViewById(R.id.logoutButton);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });

        navView = findViewById(R.id.nav_buttom);
        navView.setOnItemSelectedListener(item -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            switch (item.getItemId()){
                case R.id.ic_home:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelay, homeFragment)
                            .commit();
                    return true;

                case R.id.ic_transaction:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelay, transactionFragment)
                            .commit();
                    return true;

                case R.id.ic_aboutus:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelay, aboutusFragment)
                            .commit();
                    return true;

                default:
                    return false;
            }

        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelay,fragment);
        fragmentTransaction.commit();
    }
}