package com.example.ageapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.ageapp.databinding.ActivityMainBinding;
import com.example.ageapp.viewmodel.HomeViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        homeViewModel = new ViewModelProvider.NewInstanceFactory().create(HomeViewModel.class);

        SwitchMaterial toggle_btn = binding.switchTheme;

        toggle_btn.setOnCheckedChangeListener((compoundButton, b) -> {
            if (toggle_btn.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });



    }

    private void setAgeButtonsListener(ConstraintLayout constraintLayout) {
        for (int i = 0; i < constraintLayout.getChildCount(); i++) {
            final View child = constraintLayout.getChildAt(i);
            if (child instanceof ToggleButton) {
                child.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {

    }
}