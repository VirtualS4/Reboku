package com.reboku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailProgress extends AppCompatActivity {

    private DatabaseReference db;
    private String item_id;
    private String nama_provinsi;
    private int target_penghijauan,realisasi_penghijauan,realisasi_jumlahpohon, target_reboisasi, realisasi_reboisasi, reboisasi_jumlahpohon;
    private TextView txt_rebo_tar,txt_rebo_real,txt_rebo_poh,txt_hijau_tar,txt_hijau_real,txt_hijau_poh, txt_nama_provinsi;
    private DataReboisasi data;
    private Bundle bun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_progress);

        db = FirebaseDatabase.getInstance().getReference();
        txt_nama_provinsi = findViewById(R.id.nama_provinsi);
        txt_rebo_tar =findViewById(R.id.rebo_tar);
        txt_rebo_real =findViewById(R.id.rebo_real);
        txt_rebo_poh =findViewById(R.id.rebo_poh);
        txt_hijau_tar =findViewById(R.id.hijau_tar);
        txt_hijau_real =findViewById(R.id.hijau_real);
        txt_hijau_poh =findViewById(R.id.hijau_poh);
        bun = getIntent().getExtras();
        initbtnBack();
        item_id = "Kosong";
        if(bun.getParcelable("Data") != null){
            data = bun.getParcelable("Barang");
            item_id = data.getNama_provinsi();
            fillField();
        }
    }

    private void fillField(){

        txt_nama_provinsi.setText(String.valueOf(data.getNama_provinsi()));
        txt_rebo_tar.setText(String.valueOf(data.getTarget_reboisasi()));
        txt_rebo_real.setText(String.valueOf(data.getRealisasi_reboisasi()));
        txt_rebo_poh.setText(String.valueOf(data.getReboisasi_jumlahpohon()));
        txt_hijau_tar.setText(String.valueOf(data.getTarget_penghijauan()));
        txt_hijau_real.setText(String.valueOf(data.getRealisasi_penghijauan()));
        txt_hijau_poh.setText(String.valueOf(data.getRealisasi_jumlahpohon()));
        //getPicDatabase(data.getGambar(),img);
    }

    private void initbtnBack(){
        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bearsense = new Intent(DetailProgress.this,MainMenu.class);
                startActivity(bearsense);
            }
        });
    }


}