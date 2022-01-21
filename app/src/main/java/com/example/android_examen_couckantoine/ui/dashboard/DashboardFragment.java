package com.example.android_examen_couckantoine.ui.dashboard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.example.android_examen_couckantoine.Viewmodel.MyViewModelFactory;
import com.example.android_examen_couckantoine.databinding.FragmentDashboardBinding;
import com.example.android_examen_couckantoine.ui.Expenses.ExpensesFragment;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class DashboardFragment extends Fragment {

    private FragmentActivity mContext;
    ImageView iv_incomes;
    ImageView iv_expenses;
    ImageView iv_balance;
    TextView tv_incomes;
    TextView tv_expenses;
    TextView tv_balance;
    ProgressBar progressBar;
    double totalIncomes = 0;
    double totalExpenses = 0;
    double totalBalance = 0;
    double progression;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity) context;
    }

    public DashboardFragment(){

    }

    public static DashboardFragment newInstance() {

        return new DashboardFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_dashboard , container , false);
    }



    public void UpdateTotals(List<Budget_item> budget_items) {

                //TODO utiliser une fonction pour avoir moins de code dans le viewCreated

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get the imageviews
        iv_incomes = view.findViewById(R.id.iv_incomes);
        iv_expenses = view.findViewById(R.id.iv_expenses);
        iv_balance = view.findViewById(R.id.iv_balance);

        // set the imageviews with picasso
        Picasso.get().load(R.drawable.moneybag).into(iv_incomes);
        Picasso.get().load(R.drawable.euro).into(iv_expenses);
        Picasso.get().load(R.drawable.euro2).into(iv_balance);

        // get the other elements in UI
        tv_incomes = view.findViewById(R.id.tv_dashboard_total_incomes);
        tv_expenses = view.findViewById(R.id.tv_dashboard_total_expenses);
        tv_balance = view.findViewById(R.id.tv_dashboard_balance);
        progressBar = view.findViewById(R.id.progressBar);




        BudgetViewModel viewModel = new ViewModelProvider(this , new MyViewModelFactory(getActivity().getApplication() , 1)).get(BudgetViewModel.class);
        viewModel.getAllIncomes().observe(getViewLifecycleOwner(), budget_items -> {


            for(Budget_item item : budget_items){

                totalIncomes += item.getAmount();
                tv_incomes.setText("€"+totalIncomes);
                totalBalance = totalIncomes - totalExpenses;
                tv_balance.setText("€"+totalBalance);

                if(totalIncomes == 0){

                    progression = 0;

                } else {

                    progression = totalBalance / totalIncomes * 100;
                }


                Math.round(progression);
                progressBar.setProgress((int)progression);
                CalculteProgression((int)progression);
            }


        });

        viewModel.getAllExpenses().observe(getViewLifecycleOwner(), budget_items -> {


                for(Budget_item expense : budget_items){

                    totalExpenses += expense.getAmount();
                    tv_expenses.setText("€"+totalExpenses);
                    totalBalance = totalIncomes - totalExpenses;
                    tv_balance.setText("€"+totalBalance);

                    if(totalIncomes == 0){

                        progression = 0;

                    } else {

                        progression = totalBalance / totalIncomes * 100;
                    }


                    Math.round(progression);
                    progressBar.setProgress((int)progression);
                    CalculteProgression((int)progression);

                }

        });

    }


    public void CalculteProgression(int progression){

        if(progression >= 75){

//            progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                progressBar.setIndeterminateTintList(ColorStateList.valueOf(Color.GREEN));
            }
        }
        else if(progression >=50){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
        }
        else if(progression >= 25){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.rgb(245, 179, 66)));
            }
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }

        }
    }

}