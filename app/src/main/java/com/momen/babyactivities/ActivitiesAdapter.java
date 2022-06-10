package com.momen.babyactivities;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.AdapterViewHolder> {
    OnItemClickListener mListener;

    int lvl = 1;
    ArrayList<String> activityTitle;

    public ActivitiesAdapter(int lvl, ArrayList<String> activityTitle) {
        this.lvl = lvl;
        this.activityTitle = activityTitle;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activities, parent, false);
        return new AdapterViewHolder(view, mListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.activityTitle.setText(activityTitle.get(position).trim());
    }

    @Override
    public int getItemCount() {
        return activityTitle.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView activityTitle;

        public AdapterViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            activityTitle = itemView.findViewById(R.id.activity_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
