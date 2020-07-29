package com.example.ageapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.Calendar;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<Integer>_displayValue = new MutableLiveData<>();

    public LiveData<Integer> getDisplayValue(){
        return _displayValue;
    }

    public void returnYear(int age){
        _displayValue.setValue(Calendar.getInstance().get(Calendar.YEAR) - age);
    }

}




