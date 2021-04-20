package com.reboku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class InformationCenterRecyclerAdapter extends RecyclerView.Adapter<InformationCenterRecyclerAdapter.ViewHolder> {

    private static final String Tag = "RecyclerView";
    private  Context mContext;
    private ArrayList<InformationCenterMessages> informationCenterMessagesList;

    public InformationCenterRecyclerAdapter(Context mContext, ArrayList<InformationCenterMessages> informationCenterMessagesList) {
        this.mContext = mContext;
        this.informationCenterMessagesList = informationCenterMessagesList;
    }




    @NonNull
    @Override
    public InformationCenterRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_informationcenter, parent, false);

         return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Text View
        holder.textView.setText(informationCenterMessagesList.get(position).getName());

        //Image View
        Glide.with(mContext).load(informationCenterMessagesList.get(position).getImagesUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return informationCenterMessagesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //widgets:
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textViewy);

        }
    }
}
