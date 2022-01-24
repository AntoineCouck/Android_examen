package com.example.android_examen_couckantoine.ui.Expenses;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_examen_couckantoine.Adapters.Expense_RecyclerAdapter;
import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.example.android_examen_couckantoine.Viewmodel.MyViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ExpensesFragment extends Fragment {


    private FragmentActivity mContext;
    FloatingActionButton fab;
    private TextView tv_total_expenses;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity)context;

    }

    public ExpensesFragment() {
        // Required empty public constructor
    }

    public static ExpensesFragment newInstance() {

        return new ExpensesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.expenses_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_total_expenses = view.findViewById(R.id.tv_total_expenses);


        Expense_RecyclerAdapter adapter = new Expense_RecyclerAdapter(new ArrayList<>());


        BudgetViewModel viewModel = new ViewModelProvider(this , new MyViewModelFactory(getActivity().getApplication() , 1)).get(BudgetViewModel.class);
        viewModel.getAllExpenses().observe(getViewLifecycleOwner(), budget_items -> {
            adapter.Reload(budget_items);
            tv_total_expenses = view.findViewById(R.id.tv_total_expenses);
            double expense = 0;
            for(Budget_item item : budget_items){

                    expense += item.getAmount();
                    tv_total_expenses.setText("€"+expense);

            }
        });

        RecyclerView ExpensesRecyclerView = view.findViewById(R.id.rv_expenses);
        ExpensesRecyclerView.setAdapter(adapter);
        ExpensesRecyclerView.setLayoutManager(new LinearLayoutManager(mContext , LinearLayoutManager.VERTICAL , false));

        fab = mContext.findViewById(R.id.btn_add_expense);
        fab.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_navigation_expenses_to_createFragment));

    }


}