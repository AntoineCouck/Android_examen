package com.example.android_examen_couckantoine.ui.other;

import static java.lang.Double.parseDouble;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;



import com.example.android_examen_couckantoine.Models.BudgetType;
import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.example.android_examen_couckantoine.Viewmodel.MyViewModelFactory;
import com.example.android_examen_couckantoine.ui.dashboard.DashboardFragment;
import com.example.android_examen_couckantoine.ui.other.Dialogs.CreateLimitDialogFragment;
import com.example.android_examen_couckantoine.ui.other.Dialogs.WarningLimit;


import org.threeten.bp.LocalDate;



public class CreateFragment extends Fragment {


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }


    public CreateFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BudgetViewModel viewModel = new ViewModelProvider(this , new MyViewModelFactory(requireActivity().getApplication() , 1)).get(BudgetViewModel.class);

        EditText titleET = view.findViewById(R.id.et_title);
        EditText descriptionET = view.findViewById(R.id.et_description);
        EditText amountET = view.findViewById(R.id.et_amount);
        RadioButton ChooseIncome = view.findViewById(R.id.rd_choose_income);
        RadioButton ChooseExpense = view.findViewById(R.id.rd_choose_expense);
        Button createBtn = view.findViewById(R.id.btn_create);


        createBtn.setOnClickListener(v -> {

            Budget_item newBudget = new Budget_item();

            newBudget.setTitle(titleET.getText().toString());
            newBudget.setDescription(descriptionET.getText().toString());
            newBudget.setCreatedOn(LocalDate.now());
            newBudget.setAmount(parseDouble(amountET.getText().toString()));



            if(ChooseIncome.isChecked()){
                newBudget.setType(BudgetType.INCOME);
            }
            if(ChooseExpense.isChecked()){
                newBudget.setType(BudgetType.EXPENSE);
            }

                if ((DashboardFragment.totalBalance - Double.parseDouble(amountET.getText().toString())) < Double.parseDouble(CreateLimitDialogFragment.Limit)
                        && ChooseExpense.isChecked()
                        && CreateLimitDialogFragment.Limit != null ) {

                    new WarningLimit().show(getChildFragmentManager(), WarningLimit.TAG);

                    if (WarningLimit.Create) {
                        viewModel.Insert(newBudget);
                        Navigation.findNavController(view).navigateUp();
                    }

                }
                else {
                    viewModel.Insert(newBudget);
                    Navigation.findNavController(view).navigateUp();

                }


        });



    }
}