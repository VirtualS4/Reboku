package com.reboku;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InformationCenterHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mTextView;

    public InformationCenterHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.imageView);
        this.mTextView = itemView.findViewById(R.id.textViewy);

    }
}
