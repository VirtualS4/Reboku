package com.reboku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class ProgressReboisasiRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String Tag = "RecyclerView";
    private  Context mContext;
    private ArrayList<ProgressReboisasiMessages> progressReboisasiMessagesList;
    public ClickListener mListener;

    public ProgressReboisasiRecyclerAdapter(Context mContext, ArrayList<ProgressReboisasiMessages> progressReboisasiMessagesList,ClickListener listener) {
        this.mContext = mContext;
        this.mListener = listener;
        this.progressReboisasiMessagesList = progressReboisasiMessagesList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progressreboisasi, parent, false);

        return  new RowViewHolder(view,mListener);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Text View
        if (holder instanceof RowViewHolder) {
            RowViewHolder rowHolder = (RowViewHolder) holder;
            //set values of data here
            TextView txt_jumlah = holder.itemView.findViewById(R.id.textJumlah);
            txt_jumlah.setText(progressReboisasiMessagesList.get(position).getRealisasi_jumlahpohon());
            TextView txt_tempat = holder.itemView.findViewById(R.id.textTempat);
            txt_tempat.setText(progressReboisasiMessagesList.get(position).getNama_provinsi());
            //holder.textTempat.setText(progressReboisasiMessagesList.get(position).getNama_provinsi());
        }


    }

    @Override
    public int getItemCount() {
        return progressReboisasiMessagesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //widgets:
        TextView textTempat;
        TextView textJumlah;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textJumlah = itemView.findViewById(R.id.textJumlah);
            textTempat = itemView.findViewById(R.id.textTempat);

        }
    }
}
