package com.example.pharmacybluejack;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTransaction extends RecyclerView.Adapter<AdapterTransaction.TransViewHolder>{

    Context context;
    ArrayList<Trans> transArrayList;

    public AdapterTransaction(Context context, ArrayList<Trans> transArrayList) {
        this.context = context;
        this.transArrayList = transArrayList;
    }

    @NonNull
    @Override
    public TransViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.lisd_transaction,parent, false);
        return new TransViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TransViewHolder holder, int position) {
        holder.imageTrans.setImageResource(transArrayList.get(position).getImage_trans());
        holder.dateTrans.setText(transArrayList.get(position).getDate_trans());
        holder.nameTrans.setText(transArrayList.get(position).getName_trans());
        holder.priceTrans.setText(String.valueOf((transArrayList.get(position).getPrice_trans() * transArrayList.get(position).getQty_trans() )));
        holder.qtyTrans.setText(String.valueOf(transArrayList.get(position).getQty_trans()));

        holder.btnEdit.setOnClickListener(e ->{
            LayoutInflater inflater = (LayoutInflater) e.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            PopupWindow popup = new PopupWindow(inflater.inflate(R.layout.pop_up_transaction, null, false), LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT, true);

            popup.showAtLocation(e.getRootView(), Gravity.CENTER, 0, 0);

            EditText quantityPopup = popup.getContentView().findViewById(R.id.quantity_edit_text);
            Button savePopup = popup.getContentView().findViewById(R.id.quantity_edit_save);

            quantityPopup.setText(String.valueOf(transArrayList.get(position).getQty_trans()));

            savePopup.setOnClickListener(a -> {
                int qty = Integer.parseInt(quantityPopup.getText().toString());
                if (qty > 1){
                    transArrayList.get(position).setQty_trans(qty);
                    notifyItemChanged(position);
                    notifyItemRangeChanged(position, getItemCount());
                    popup.dismiss();
                    return;
                }
                Toast.makeText(e.getContext(), "Cannot 0 item", Toast.LENGTH_SHORT).show();
            });
        });

        holder.btnDelete.setOnClickListener(e ->{
            transArrayList.remove(transArrayList.get(position));
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        });

    }

    @Override
    public int getItemCount() {
        return HomeActivity.transacArrayList.size();
    }


    class TransViewHolder extends RecyclerView.ViewHolder{
        ImageView imageTrans;
        TextView dateTrans, nameTrans, priceTrans, qtyTrans;
        ImageButton btnEdit, btnDelete;


        public TransViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTrans = itemView.findViewById(R.id.transImage);
            dateTrans = itemView.findViewById(R.id.transDate);
            nameTrans = itemView.findViewById(R.id.transName);
            priceTrans = itemView.findViewById(R.id.transPrice);
            qtyTrans = itemView.findViewById(R.id.transQty);
            btnEdit = itemView.findViewById(R.id.editBtn);
            btnDelete = itemView.findViewById(R.id.dltBtn);
        }
    }
}

