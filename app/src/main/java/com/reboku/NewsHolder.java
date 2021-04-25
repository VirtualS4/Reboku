package com.reboku;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsHolder extends RecyclerView.ViewHolder {

    ImageView myImageView;
    TextView myTittleView;


    public NewsHolder(@NonNull View itemView) {
        super(itemView);

        this.myImageView = itemView.findViewById(R.id.imageNews);
        this.myTittleView = itemView.findViewById(R.id.textTittleNews);


    }
}
