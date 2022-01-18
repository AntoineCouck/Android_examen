package com.example.android_examen_couckantoine.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.android_examen_couckantoine.Database.AppDatabase;
import com.example.android_examen_couckantoine.Models.BudgetType;
import com.example.android_examen_couckantoine.Models.Budget_item;

import java.util.ArrayList;

public class BudgetViewModel extends AndroidViewModel {

    //    private MutableLiveData<String> mText;
//
//    public HomeViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
//    }
//
//    public LiveData<String> getText() {
//        return mText;
//    }


    private final MutableLiveData<ArrayList<Budget_item>> SharedItems;
    private final MutableLiveData<ArrayList<Budget_item>> AllIncomes;
    private final MutableLiveData<ArrayList<Budget_item>> AllExpenses;
    private final AppDatabase database;


    public BudgetViewModel(@NonNull Application application) {
        super(application);
        database = AppDatabase.getInstance(application);

        SharedItems = database.getDAO().getAllItems();
        AllIncomes = database.getDAO().getAllIncomes(BudgetType.INCOME);
        AllExpenses = database.getDAO().getAllExpenses(BudgetType.EXPENSE);

    }

    public MutableLiveData<ArrayList<Budget_item>> getSharedItems() {
        return SharedItems;
    }

    public MutableLiveData<ArrayList<Budget_item>> getAllIncomes() {
        return AllIncomes;
    }

    public MutableLiveData<ArrayList<Budget_item>> getAllExpenses() {
        return AllExpenses;
    }

    public void Insert(Budget_item item){

        AppDatabase.databaseexe.execute(() ->
                database.getDAO().insertBudget(item)
        );

    }

    public void Update(Budget_item item){

        AppDatabase.databaseexe.execute(() ->

                database.getDAO().updateBudget(item)

        );

    }

}
