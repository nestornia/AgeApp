package com.example.ageapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ageapp.adapters.PhoneLogAdapter;
import com.example.ageapp.databinding.RecyclerMainBinding;
import com.example.ageapp.viewmodel.RecyclerViewModel;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerMainBinding binding;
    private RecyclerViewModel recyclerViewModel;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RecyclerMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        recyclerViewModel = new ViewModelProvider(this).get(RecyclerViewModel.class);
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));

        binding.rvList.setAdapter(new PhoneLogAdapter(recyclerViewModel.getData()));
    }
}
