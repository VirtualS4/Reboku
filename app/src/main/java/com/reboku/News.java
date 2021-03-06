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

public class News extends AppCompatActivity {


    RecyclerView recyclerView;



    //firebase:
    private DatabaseReference myRef;

    //Variables
    private ArrayList<NewsMessages> newsMessagesList;
    private NewsRecyclerAdapter recyclerAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = findViewById(R.id.recyclerViewNews);

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


        //Arraylist:
        newsMessagesList = new ArrayList<>();

        //firebase
        myRef = FirebaseDatabase.getInstance().getReference();

        //clear array list
        ClearAll();

        Query query = myRef.child("berita");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    NewsMessages newsMessages = new NewsMessages();

                    newsMessages.setJudul(snapshot.child("Judul").getValue().toString());

                    newsMessages.setImageUrlNews(snapshot.child("image").getValue().toString());

                    newsMessagesList.add(newsMessages);
                }

                recyclerAdapter = new NewsRecyclerAdapter(getApplicationContext(), newsMessagesList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void ClearAll(){
        if(newsMessagesList != null){
            newsMessagesList.clear();

            if (recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }

        newsMessagesList = new ArrayList<>();

    }



}