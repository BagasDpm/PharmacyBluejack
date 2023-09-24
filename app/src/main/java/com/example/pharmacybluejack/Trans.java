package com.example.pharmacybluejack;

import android.widget.ImageButton;

public class Trans {

    String name_trans, date_trans;
    int image_trans, price_trans, qty_trans;

    public Trans(String name_trans, String date_trans, int image_trans, int price_trans, int qty_trans) {
        this.name_trans = name_trans;
        this.date_trans = date_trans;
        this.image_trans = image_trans;
        this.price_trans = price_trans;
        this.qty_trans = qty_trans;
    }

    public String getName_trans() {
        return name_trans;
    }

    public void setName_trans(String name_trans) {
        this.name_trans = name_trans;
    }

    public String getDate_trans() {
        return date_trans;
    }

    public void setDate_trans(String date_trans) {
        this.date_trans = date_trans;
    }

    public int getImage_trans() {
        return image_trans;
    }

    public void setImage_trans(int image_trans) {
        this.image_trans = image_trans;
    }

    public int getPrice_trans() {
        return price_trans;
    }

    public void setPrice_trans(int price_trans) {
        this.price_trans = price_trans;
    }

    public int getQty_trans() {
        return qty_trans;
    }

    public void setQty_trans(int qty_trans) {
        this.qty_trans = qty_trans;
    }
}
