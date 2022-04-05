package com.momen.babyactivities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {
    private List<com.momen.babyactivities.OnBoardingItem> onBoardingItems;

    public OnboardingAdapter(List<com.momen.babyactivities.OnBoardingItem> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.on_boarding_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {

        holder.setOnBoardingData(onBoardingItems.get(position), position);


    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;
        ImageView vector;

        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);

            vector = itemView.findViewById(R.id.vector);
        }

        void setOnBoardingData(com.momen.babyactivities.OnBoardingItem onBoardingItem, int position) {


            vector.setImageResource(onBoardingItem.getImage());

        }
    }
}