package com.reboku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProgressReboisasi extends AppCompatActivity {
    RecyclerView recyclerView;


    //firebase:
    private DatabaseReference myRef;


    //Variables
    private ArrayList<ProgressReboisasiMessages> progressReboisasiMessagesList;
    private ProgressReboisasiRecyclerAdapter recyclerAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_reboisasi);
        recyclerView = findViewById(R.id.recyclerView2);

        ImageView back = findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToHome = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(goToHome);
            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        //firebase
        myRef = FirebaseDatabase.getInstance().getReference();

        //Arraylist:
        progressReboisasiMessagesList = new ArrayList<>();

        //clear array list
        ClearAll();

        //get data method
        GetDataFromFirebase();
        Query query = myRef.child("progress-reboisasi");

        query.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ProgressReboisasiMessages progressReboisasiMessages = new ProgressReboisasiMessages();

                    String nama_prov = snapshot.child("tempat").getValue().toString();
                    String hijau_real = snapshot.child("jumlah").getValue().toString();

                    progressReboisasiMessagesList.add(progressReboisasiMessages);
                }
                ClickListener listener = (view, position) -> {
                    Intent bearsense = new Intent(ProgressReboisasi.this,DetailProgress.class);
                    ProgressReboisasiMessages bear = progressReboisasiMessagesList.get(position);
                    bearsense.putExtra("Barang",bear);
                    bearsense.putExtra("ViewOnly","No");
                    startActivity(bearsense);
                };
                recyclerAdapter = new ProgressReboisasiRecyclerAdapter(getApplicationContext(), progressReboisasiMessagesList,listener);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void GetDataFromFirebase(){


    }

    private void ClearAll(){
        if(progressReboisasiMessagesList != null){
            progressReboisasiMessagesList.clear();

            if (recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }

        progressReboisasiMessagesList = new ArrayList<>();

    }



}