package com.example.android_examen_couckantoine.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.android_examen_couckantoine.Database.Budgetdatabase;
import com.example.android_examen_couckantoine.Models.BudgetType;
import com.example.android_examen_couckantoine.Models.Budget_item;

import java.util.List;

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


    private final LiveData<List<Budget_item>> SharedItems;
    private final LiveData<List<Budget_item>> AllIncomes;
    private final LiveData<List<Budget_item>> AllExpenses;
    private final Budgetdatabase database;
    private final long id;

    public BudgetViewModel(@NonNull Application application , final long id) {
        super(application);
        this.id = id;
        database = Budgetdatabase.getInstance(application);

        SharedItems = database.getDAO().getAllItems();
        AllIncomes = database.getDAO().getAllIncomes(BudgetType.INCOME);
        AllExpenses = database.getDAO().getAllExpenses(BudgetType.EXPENSE);

    }

    public LiveData<List<Budget_item>> getSharedItems() {
        return SharedItems;
    }

    public LiveData<List<Budget_item>> getAllIncomes() {
        return AllIncomes;
    }

    public LiveData<List<Budget_item>> getAllExpenses() {
        return AllExpenses;
    }

    public void Insert(Budget_item item){

        Budgetdatabase.databaseexe.execute(() ->
                database.getDAO().insertBudget(item)
        );

    }

    public void Update(Budget_item item){

        Budgetdatabase.databaseexe.execute(() ->

                database.getDAO().updateBudget(item)

        );

    }

}
