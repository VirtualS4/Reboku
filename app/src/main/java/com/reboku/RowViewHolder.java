package com.reboku;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ClickListener mListener;

    RowViewHolder(View v, ClickListener listener) {
        super(v);
        mListener = listener;
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(view, getAdapterPosition());
    }
}
