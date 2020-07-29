package com.example.ageapp.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView ;
import com.example.ageapp.R;

import com.example.ageapp.databinding.ColorItemBinding;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {


    private List<String> colors;

    public ColorAdapter(List<String> colors) {
        this.colors = colors;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.colors_main, parent,false);

        ColorItemBinding binding = ColorItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ColorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.binding.tvColor.setText(colors.get(position));
        holder.binding.cvColor.setBackgroundColor(Integer.parseInt(colors.get(position)));
    }

    @Override
    public int getItemCount() {

        return colors.size();
    }

    static class ColorViewHolder extends RecyclerView.ViewHolder {
        private final ColorItemBinding binding;


        public ColorViewHolder(@NonNull ColorItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
