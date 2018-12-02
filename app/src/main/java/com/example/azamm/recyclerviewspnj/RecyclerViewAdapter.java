package com.example.azamm.recyclerviewspnj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mNamaTempat;
    private ArrayList<String> mImages;
    private Context mContext;

    public RecyclerViewAdapter( Context mContext, ArrayList<String> mNamaTempat, ArrayList<String> mImages) {
        this.mNamaTempat = mNamaTempat;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()
        ).inflate(R.layout.layout_list_tempat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: inisiasi data");

        Glide.with(mContext)
                .load(mImages.get(position))
                .into(holder.fotoTempat);

        holder.namaTempat.setText(mNamaTempat.get(position));
        Log.d(TAG, "onBindViewHolder: nama tempat" + mNamaTempat);
    }

    @Override
    public int getItemCount() {
        return mNamaTempat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView fotoTempat;
        TextView namaTempat;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoTempat = itemView.findViewById(R.id.imageListLayoutFotoTempat);
            namaTempat = itemView.findViewById(R.id.textListLayoutNamaTempat);
            parentLayout = itemView.findViewById(R.id.relativeListLayoutParent);
        }
    }
}
