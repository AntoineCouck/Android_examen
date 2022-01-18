package com.example.android_examen_couckantoine.Models;

import androidx.room.Entity;
import androidx.room.Ignore;

import org.threeten.bp.LocalDate;

import java.io.Serializable;

@Entity
public class Budget_item  implements Serializable {

    private long Id;

    private String Title;
    private String Description;
    private LocalDate CreatedOn;
    private double Amount;
    private BudgetType type;

    public Budget_item() {
    }

    @Ignore
    public Budget_item(String title, String description , double amount, BudgetType type) {

        Title = title;
        Description = description;
        CreatedOn = LocalDate.now();
        Amount = amount;
        this.type = type;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        CreatedOn = createdOn;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public BudgetType getType() {
        return type;
    }

    public void setType(BudgetType type) {
        this.type = type;
    }


}
