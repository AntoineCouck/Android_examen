package com.example.android_examen_couckantoine.Adapters;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;

import java.util.List;

public class Income_RecyclerAdapter  extends RecyclerView.Adapter<Income_RecyclerAdapter.BudgetItemViewHolder> {



    class BudgetItemViewHolder extends RecyclerView.ViewHolder {

        final TextView title,amount;
        final CardView card;


        public BudgetItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_card_title);
            amount = itemView.findViewById(R.id.tv_card_amount);
            card = itemView.findViewById(R.id.budget_card);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    Budget_item toPass = AllBudget.get(position);

                    Bundle data = new Bundle();

                    data.putSerializable("Budget_item" , toPass);

                    Navigation.findNavController(itemView).navigate(R.id.action_navigation_home_to_createFragment);


                }
            });

        }


    }

    private List<Budget_item> AllBudget;

    public Income_RecyclerAdapter(List<Budget_item> allBudget) {
        AllBudget = allBudget;
    }

    public void Reload(List<Budget_item> NewReload){

        this.AllBudget = NewReload;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public BudgetItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View row = LayoutInflater.from(context).inflate(R.layout.budget_card , parent , false);

        return new BudgetItemViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetItemViewHolder holder, int position) {

        Budget_item currentItem = AllBudget.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.amount.setText((int) currentItem.getAmount());

    }

    @Override
    public int getItemCount() {
        return AllBudget.size();
    }



}
