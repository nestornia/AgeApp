package com.example.ageapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;

import com.example.ageapp.databinding.ActivityMainBinding;
import com.example.ageapp.viewmodel.HomeViewModel;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private HomeViewModel homeViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        View view = binding.getRoot();
        setContentView(view);
        homeViewModel = new ViewModelProvider.NewInstanceFactory().create(HomeViewModel.class);
        homeViewModel.getDisplayValue().observe(this, integer -> binding.userYear.setText(String.format(Locale.getDefault(), "%d", integer)));

        binding.switchTheme.setOnCheckedChangeListener((compoundButton, b) -> {
            if ( binding.switchTheme.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeViewModel.returnYear(Integer.parseInt(String.valueOf(binding.ageInput.getText())));
            }
        });
    }


}
