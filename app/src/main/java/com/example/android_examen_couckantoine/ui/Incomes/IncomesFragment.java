package com.example.android_examen_couckantoine.ui.Incomes;

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

import com.example.android_examen_couckantoine.Adapters.Income_RecyclerAdapter;
import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;



    public class IncomesFragment extends Fragment {


        private FragmentActivity mContext;


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



//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_incomes, container, false);

        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            Income_RecyclerAdapter adapter = new Income_RecyclerAdapter(new ArrayList<>());


            BudgetViewModel viewModel = new ViewModelProvider(mContext).get(BudgetViewModel.class);
            viewModel.getAllIncomes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Budget_item>>() {
                @Override
                public void onChanged(ArrayList<Budget_item> budget_items) {

                    adapter.Reload(budget_items);

                }
            });

            RecyclerView IncomeRecyclerView = view.findViewById(R.id.rv_incomes);
            IncomeRecyclerView.setAdapter(adapter);
            IncomeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext , LinearLayoutManager.VERTICAL , true));


            FloatingActionButton fab = mContext.findViewById(R.id.btn_create);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_createFragment);

                }
            });

        }



    }