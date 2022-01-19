package com.example.android_examen_couckantoine.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    private final Application application;

    private final long id;

    public MyViewModelFactory(@NonNull Application application, long id) {
        this.application = application;
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == BudgetViewModel.class) {
            return (T) new BudgetViewModel(application, id);
        }
        return null;
    }
}
