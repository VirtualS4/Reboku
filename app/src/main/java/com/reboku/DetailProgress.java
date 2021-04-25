package com.reboku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.util.ScopeUtil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class DetailProgress extends AppCompatActivity {

    private DatabaseReference db;
    private String item_id;
    private String nama_provinsi;
    private int target_penghijauan,realisasi_penghijauan,realisasi_jumlahpohon, target_reboisasi, realisasi_reboisasi, reboisasi_jumlahpohon;
    private TextView txt_rebo_tar,txt_rebo_real,txt_rebo_poh,txt_hijau_tar,txt_hijau_real,txt_hijau_poh, txt_nama_provinsi;
    private ProgressReboisasiMessages data;
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
        System.out.println("Test 1");
        if(bun.getParcelable("Data") != null){
            System.out.println("Test 2");
            data = bun.getParcelable("Data");
            //item_id = data.getNama_provinsi();
            System.out.println(data.getNama_provinsi());
            fillField();
        }
    }

    private void fillField(){
        //System.out.println(data.getNama_provinsi());
        //System.out.println(data.getRealisasi_jumlahpohon());
        txt_nama_provinsi.setText(data.getNama_provinsi());
        txt_rebo_tar.setText(data.getTarget_reboisasi()+" HA");
        txt_rebo_real.setText(data.getRealisasi_reboisasi()+" HA");
        txt_rebo_poh.setText(data.getReboisasi_jumlahpohon());
        txt_hijau_tar.setText(data.getTarget_penghijauan()+" HA");
        txt_hijau_real.setText(data.getRealisasi_penghijauan()+ " HA");
        txt_hijau_poh.setText(data.getRealisasi_jumlahpohon());
        //getPicDatabase(data.getGambar(),img);
    }

    private void initbtnBack(){
        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bearsense = new Intent(DetailProgress.this,ProgressReboisasi.class);
                startActivity(bearsense);
            }
        });
    }

    private String currencyFormatter(String num) {
        double m = Double.parseDouble(num);
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(m);
    }


}