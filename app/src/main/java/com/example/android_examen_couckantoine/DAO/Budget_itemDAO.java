package com.example.android_examen_couckantoine.DAO;

import androidx.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.android_examen_couckantoine.Models.BudgetType;
import com.example.android_examen_couckantoine.Models.Budget_item;

import java.util.List;

@Dao
public interface Budget_itemDAO {


    @Query("SELECT * FROM Budget_item")
   LiveData<List<Budget_item>> getAllItems();

    @Query("SELECT * FROM budget_item WHERE type LIKE :income")
    LiveData<List<Budget_item>> getAllIncomes(BudgetType income);

    @Query("SELECT * FROM budget_item WHERE type LIKE :expense")
    LiveData<List<Budget_item>>getAllExpenses(BudgetType expense);

    @Query("SELECT * FROM budget_item WHERE Title LIKE :title")
    LiveData<List<Budget_item>>GetByTitle(String title);

    @Insert
    void insertBudget(Budget_item item);

    @Delete
    void deleteBudget(Budget_item item);

    @Update
    void updateBudget(Budget_item item);

}
