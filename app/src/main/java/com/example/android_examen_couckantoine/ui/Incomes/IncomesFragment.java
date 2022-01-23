package com.example.android_examen_couckantoine.ui.Incomes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_examen_couckantoine.Adapters.Income_RecyclerAdapter;
import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.example.android_examen_couckantoine.Viewmodel.MyViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class IncomesFragment extends Fragment {


        private FragmentActivity mContext;
         FloatingActionButton fab;
         private TextView tv_total_incomes;

        @Override
        public void onAttach(@NonNull Context context) {
            super.onAttach(context);
            mContext = (FragmentActivity)context;
        }

        public IncomesFragment() {
            // Required empty public constructor
        }

        public static IncomesFragment newInstance() {

            return new IncomesFragment();
        }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.incomes_layout, container, false);

        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            tv_total_incomes = view.findViewById(R.id.tv_total_incomes);

            Income_RecyclerAdapter adapter = new Income_RecyclerAdapter(new ArrayList<>());


            BudgetViewModel viewModel = new ViewModelProvider(this , new MyViewModelFactory(getActivity().getApplication() , 1)).get(BudgetViewModel.class);
            viewModel.getAllIncomes().observe(getViewLifecycleOwner(), budget_items -> {

                adapter.Reload(budget_items);
                tv_total_incomes = view.findViewById(R.id.tv_total_incomes);
                double income = 0;
                for(Budget_item item : budget_items){

                    income += item.getAmount();
                    tv_total_incomes.setText("€"+income);

                }


            });

            RecyclerView IncomeRecyclerView = view.findViewById(R.id.rv_incomes);
            IncomeRecyclerView.setAdapter(adapter);
            IncomeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext , LinearLayoutManager.VERTICAL , false));


            fab = mContext.findViewById(R.id.btn_add_income);
            fab.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_navigation_home_to_createFragment));

        }



    }