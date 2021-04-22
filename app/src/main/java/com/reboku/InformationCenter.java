package com.reboku;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class InformationCenter extends AppCompatActivity {


    RecyclerView recyclerView;



    //firebase:
    private DatabaseReference myRef;


    //Variables
    private ArrayList<InformationCenterMessages> informationCenterMessagesList;
    private InformationCenterRecyclerAdapter recyclerAdapter;
    private Context mContext;


    //OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_center);
        recyclerView = findViewById(R.id.recyclerView);

        //backButton
        ImageView back = findViewById(R.id.backbutton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHome= new Intent(getApplicationContext(), MainMenu.class);
                startActivity(goToHome);
            }
        });







        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        //firebase
        myRef = FirebaseDatabase.getInstance().getReference();

        //Arraylist:
        informationCenterMessagesList = new ArrayList<>();

        //clear array list
        ClearAll();

        //get data method
        GetDataFromFirebase();
        Query query = myRef.child("information-center");

        query.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    InformationCenterMessages informationCenterMessages = new InformationCenterMessages();

                    informationCenterMessages.setName(snapshot.child("tittle").getValue().toString());
                    informationCenterMessages.setImagesUrl(snapshot.child("image").getValue().toString());

                    informationCenterMessagesList.add(informationCenterMessages);
                }

                recyclerAdapter = new InformationCenterRecyclerAdapter(getApplicationContext(), informationCenterMessagesList);
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
        if(informationCenterMessagesList != null){
            informationCenterMessagesList.clear();

            if (recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }

        informationCenterMessagesList = new ArrayList<>();

    }






}
