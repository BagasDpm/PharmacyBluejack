package com.example.pharmacybluejack;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMedic extends RecyclerView.Adapter<AdapterMedic.MedViewHolder> {

    Context context;
    ArrayList<Meds> medsArrayList;
    public AdapterMedic(Context context, ArrayList<Meds>medsArrayList) {
        this.context = context;
        this.medsArrayList = medsArrayList;
    }

    @NonNull
    @Override
    public MedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MedViewHolder holder, int position) {
        holder.image_obat.setImageResource(medsArrayList.get(position).getImage_obat());
        holder.name_obat.setText(medsArrayList.get(position).getName_obat());
        holder.desc_obat.setText(medsArrayList.get(position).getDesc_obat());
        holder.price_obat.setText(String.valueOf(medsArrayList.get(position).getPrice_obat()));

        holder.itemView.setOnClickListener(e ->{
            Intent detail = new Intent(holder.itemView.getContext(), DetailMed.class);
            detail.putExtra("ImageObat", medsArrayList.get(position).image_obat);
            detail.putExtra("NamaObat", medsArrayList.get(position).name_obat);
            detail.putExtra("ManObat", medsArrayList.get(position).desc_obat);
            detail.putExtra("PriceObat", medsArrayList.get(position).price_obat);
            detail.putExtra("DescObat", medsArrayList.get(position).description);
            e.getContext().startActivity(detail);
        });
    }

    @Override
    public int getItemCount() {
        return medsArrayList.size();
    }

    public static class MedViewHolder extends RecyclerView.ViewHolder{
        private ImageView image_obat;
        private TextView name_obat, desc_obat, price_obat;

        public MedViewHolder(@NonNull View itemView) {
            super(itemView);
            image_obat = itemView.findViewById(R.id.image_obat);
            name_obat = itemView.findViewById(R.id.name_obat);
            desc_obat = itemView.findViewById(R.id.desc_obat);
            price_obat = itemView.findViewById(R.id.price_obat);
        }
    }
}
