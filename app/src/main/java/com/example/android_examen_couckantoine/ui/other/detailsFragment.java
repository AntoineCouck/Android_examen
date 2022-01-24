package com.example.android_examen_couckantoine.ui.other;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_examen_couckantoine.Models.BudgetType;
import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.example.android_examen_couckantoine.Viewmodel.MyViewModelFactory;


public class detailsFragment extends Fragment {

    private FragmentActivity mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity) context;
    }


    public detailsFragment() {
        // Required empty public constructor
    }



    public static detailsFragment newInstance() {
        detailsFragment fragment = new detailsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BudgetViewModel viewModel = new ViewModelProvider(this , new MyViewModelFactory(getActivity().getApplication() , 1)).get(BudgetViewModel.class);

        Budget_item passedItem = (getArguments() != null) ? (Budget_item) getArguments().getSerializable("Budget") : null;

        if(passedItem != null){

            TextView tvTitle = view.findViewById(R.id.tv_details_title);
            TextView tvDescription = view.findViewById(R.id.tv_details_description);
            TextView tvAmount = view.findViewById(R.id.tv_details_amount);
            TextView tvDate = view.findViewById(R.id.tv_details_date);
            TextView tv_type = view.findViewById(R.id.tv_details_type);
            Button btn_back = view.findViewById(R.id.btn_detaills_back);
            Button btn_delete = view.findViewById(R.id.btn_details_delete);

            tvTitle.setText(passedItem.getTitle());
            tvDescription.setText(passedItem.getDescription());
            tvAmount.setText("€"+passedItem.getAmount());
            tvDate.setText(passedItem.getCreatedOn().toString());
            tv_type.setText(passedItem.getType().toString());

            if(passedItem.getType().equals(BudgetType.INCOME)){

                tvAmount.setTextColor(Color.parseColor("#34eb46"));

            } else {

                tvAmount.setTextColor(Color.parseColor("#e82020"));

            }

            btn_back.setOnClickListener(v -> Navigation.findNavController(view).navigateUp());

            btn_delete.setOnClickListener(v -> {

                viewModel.Delete(passedItem);
                Navigation.findNavController(view).navigateUp();

            });


        }


    }
}