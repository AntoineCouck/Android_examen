package com.example.android_examen_couckantoine.ui.other.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Viewmodel.BudgetViewModel;
import com.example.android_examen_couckantoine.Viewmodel.MyViewModelFactory;
import com.example.android_examen_couckantoine.ui.other.CreateFragment;

import java.util.Objects;

public class WarningLimit extends DialogFragment {

    private FragmentActivity mContext;
    public static String TAG = "LimitWarningDialog";
    private boolean Create;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity) context;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());

        mBuilder.setTitle(R.string.txt_title_Warningdialog);
        mBuilder.setIcon(R.drawable.warning);

        mBuilder.setPositiveButton(R.string.txt_wariningdialog_toDashboard, (dialog, which) -> {


            Create = false;
            Navigation.findNavController(mContext , R.id.nav_host_fragment_activity_main).navigate(R.id.action_warningLimit_to_navigation_d);

        });

        mBuilder.setNegativeButton(R.string.txt_warningdialog_create, (dialog, which) -> {


            Bundle data = new Bundle();
            Create = true;
            data.putBoolean("create_item", Create);
            Navigation.findNavController(mContext , R.id.nav_host_fragment_activity_main).navigate(R.id.action_warningLimit_to_navigation_d , data);

        });

        return mBuilder.create();
    }


}
