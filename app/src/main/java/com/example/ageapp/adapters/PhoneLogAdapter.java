package com.example.ageapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageapp.R;
import com.example.ageapp.databinding.ItemListBinding;

import java.util.List;

public class PhoneLogAdapter extends RecyclerView.Adapter<PhoneLogAdapter.PhoneLogViewHolder> {

    private List<String> stringList;

    public PhoneLogAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    static class PhoneLogViewHolder extends RecyclerView.ViewHolder {
        private final ItemListBinding binding;


        public PhoneLogViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public PhoneLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_main, parent, false);

        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhoneLogViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneLogViewHolder holder, int position) {
        holder.binding.tvName.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

}
