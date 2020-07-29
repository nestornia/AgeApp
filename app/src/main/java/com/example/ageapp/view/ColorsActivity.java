package com.example.ageapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ageapp.adapters.ColorAdapter;
import com.example.ageapp.databinding.ColorsMainBinding;
import com.example.ageapp.viewmodel.ColorViewModel;

public class ColorsActivity extends AppCompatActivity {

    // We need our binding activity here private
    private ColorsMainBinding binding;
    // We need our ViewModel here private
    private ColorViewModel colorViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ColorsMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        colorViewModel = new ViewModelProvider(this).get(ColorViewModel.class);
        binding.rvColorList.setLayoutManager(new LinearLayoutManager(this));

        binding.rvColorList.setAdapter(new ColorAdapter(colorViewModel.getData()));
    }

}
