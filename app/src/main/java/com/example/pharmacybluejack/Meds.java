package com.example.pharmacybluejack;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Meds {

    String name_obat, desc_obat, description;
    int image_obat;
    int price_obat;

    public Meds(String name_obat, String desc_obat, String description, int image_obat, int price_obat) {
        this.name_obat = name_obat;
        this.desc_obat = desc_obat;
        this.description = description;
        this.image_obat = image_obat;
        this.price_obat = price_obat;
    }

    public String getName_obat() {
        return name_obat;
    }

    public void setName_obat(String name_obat) {
        this.name_obat = name_obat;
    }

    public String getDesc_obat() {
        return desc_obat;
    }

    public void setDesc_obat(String desc_obat) {
        this.desc_obat = desc_obat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_obat() {
        return image_obat;
    }

    public void setImage_obat(int image_obat) {
        this.image_obat = image_obat;
    }

    public int getPrice_obat() {
        return price_obat;
    }

    public void setPrice_obat(int price_obat) {
        this.price_obat = price_obat;
    }
}
