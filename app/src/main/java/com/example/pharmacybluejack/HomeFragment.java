package com.example.pharmacybluejack;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Meds> medsArrayList;
    private int[] medsImage;
    private int[] medsPrice;
    private String[] medsName;
    private String[] medsDesc;
    private String[] description;
    private RecyclerView recyclerview;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recycleview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        AdapterMedic adapterMedic = new AdapterMedic(getContext(), medsArrayList);
        recyclerview.setAdapter(adapterMedic);
        adapterMedic.notifyDataSetChanged();

    }

    private void dataInitialize() {

        medsArrayList = new ArrayList<>();

        medsImage = new int[]{
                R.drawable.promag,
                R.drawable.sanmol,
                R.drawable.cefadroxil
        };

        medsName = new String[]{
                "Promag 6 Sachet",
                "Cefadroxil 500mg 10 Kapsul",
                "Sanmol Forte 4 Tablet"
        };
        medsDesc = new String[]{
                "Kalbe Farma",
                "Generic Manufacturer",
                "Sanbe Farma"
        };
        medsPrice = new int[]{
                20000,
                21000,
                23000
        };

        description = new String[]{
                "PROMAG merupakan obat sakit maag yang mengandung Hydrotalcite, Magnesium Hydroxide, dan Simethicone. Obat ini diigunakan untuk meringankan gejala sakit maag akibat kelebihan asam lambung seperti perih, mual, kembung, dan nyeri ulu hati",
                "CEFADROXIL merupakan antibiotika golongan Cefalosporin. Antibiotika ini bekerja dengan cara mengikat 1 atau lebih protein pengikat penisilin (PBPs) yang pada gilirannya menghalangi langkah transpeptidasi akhir sintesis peptidoglikan di dinding sel bakteri, sehingga menghambat biosintesis dinding sel dan menahan perakitan dinding sel yang mengakibatkan lisis bakteri. Antibiotik ini digunakan untuk mengatasi infeksi saluran pernafasan, saluran kemih dan kelamin serta infeksi kulit dan jaringan lunak. Dalam penggunaan obat ini harus SESUAI DENGAN PETUNJUK DOKTER",
                "SANMOL FORTE merupakan obat dengan kandungan Paracetamol 650 mg. Obat ini digunakan untuk meringankan rasa sakit pada keadaan sakit kepala, sakit gigi dan menurunkan demam. Sanmol Forte bekerja pada pusat pengatur suhu di hipotalamus untuk menurunkan suhu tubuh (antipiretik) serta menghambat sintesis prostaglandin sehingga dapat mengurangi nyeri ringan sampai sedang (analgetik)"
        };

        for (int i = 0; i < medsName.length; i++){
            Meds meds = new Meds(medsName[i], medsDesc[i], description[i], medsImage[i], medsPrice[i]);
            medsArrayList.add(meds);
        }
    }
}