package com.example.android_examen_couckantoine.ui.Expenses;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_examen_couckantoine.Adapters.Expenses_RecyclerAdapter;
import com.example.android_examen_couckantoine.Adapters.Income_RecyclerAdapter;
import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.example.android_examen_couckantoine.Viewmodel.MyViewModelFactory;
import com.example.android_examen_couckantoine.ui.Incomes.IncomesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ExpensesFragment extends Fragment {


    private FragmentActivity mContext;
    FloatingActionButton fab;

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

        Expenses_RecyclerAdapter adapter = new Expenses_RecyclerAdapter(new ArrayList<>());


        BudgetViewModel viewModel = new ViewModelProvider(this , new MyViewModelFactory(getActivity().getApplication() , 1)).get(BudgetViewModel.class);
        viewModel.getAllExpenses().observe(getViewLifecycleOwner(), new Observer<List<Budget_item>>() {
            @Override
            public void onChanged(List<Budget_item> budget_items) {

                adapter.Reload(budget_items);

            }
        });

        RecyclerView IncomeRecyclerView = view.findViewById(R.id.rv_expenses);
        IncomeRecyclerView.setAdapter(adapter);
        IncomeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext , LinearLayoutManager.VERTICAL , false));


        fab = mContext.findViewById(R.id.btn_add_expense);
        fab.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_navigation_expenses_to_createFragment));

    }

}