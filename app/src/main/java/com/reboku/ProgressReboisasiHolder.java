package com.reboku;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgressReboisasiHolder extends RecyclerView.ViewHolder{
    TextView myJumlahView;
    TextView myTempatView;
    public ProgressReboisasiHolder(@NonNull View itemView) {
        super(itemView);
        this.myTempatView =itemView.findViewById(R.id.textTempat);
        this.myJumlahView = itemView.findViewById(R.id.textJumlah);
    }
}
