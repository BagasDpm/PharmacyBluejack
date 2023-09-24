package com.example.pharmacybluejack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailMed extends AppCompatActivity {

    ImageView detailimage;
    TextView namemed;
    TextView manufacturemed;
    TextView pricemed;
    TextView descmed;
    Button backmed, buymed;
    EditText quantitymed;
    String nameMed, descriptionMed, manufactureMed;
    Integer priceMed, imageMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_med);

        nameMed = getIntent().getStringExtra("NamaObat");
        manufactureMed = getIntent().getStringExtra("ManObat");
        descriptionMed = getIntent().getStringExtra("DescObat");
        priceMed = getIntent().getIntExtra("PriceObat", 0);
        imageMed = getIntent().getIntExtra("ImageObat", 0);

        detailimage = findViewById(R.id.detail_image);
        namemed = findViewById(R.id.name_med);
        manufacturemed = findViewById(R.id.manufacture_med);
        pricemed = findViewById(R.id.price_med);
        descmed = findViewById(R.id.desc_med);
        quantitymed = findViewById(R.id.quantity_med);

        buymed = findViewById(R.id.buy_med);
        buymed.setOnClickListener(e ->{
            DateFormat df = new SimpleDateFormat("dd MM yyyy - HH:mm");
            Calendar calendar = Calendar.getInstance();

            HomeActivity.transacArrayList.add(new Trans(nameMed, df.format(calendar.getTime()), imageMed, priceMed, Integer.parseInt(quantitymed.getText().toString())));
            Toast.makeText(this, "Success Added", Toast.LENGTH_SHORT).show();
        });

        backmed = findViewById(R.id.back_med);
        backmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(DetailMed.this, HomeActivity.class));
            }
        });
        detailimage.setImageResource(imageMed);
        namemed.setText(nameMed);
        manufacturemed.setText(manufactureMed);
        pricemed.setText(String.valueOf(priceMed));
        descmed.setText(descriptionMed);
    }
}