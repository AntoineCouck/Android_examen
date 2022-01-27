package com.example.android_examen_couckantoine.ui.other.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import com.example.android_examen_couckantoine.R;


public class CreateLimitDialogFragment extends DialogFragment {

    private FragmentActivity mContext;
    public static String Limit;
    public static String TAG = "PurchaseConfirmationDialog";



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity) context;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setTitle(R.string.txt_title_limitDialog);
        mBuilder.setIcon(R.drawable.limited);


        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.limitdialog, (ViewGroup) getView(), false);

        final EditText input = (EditText) viewInflated.findViewById(R.id.et_number_limit);

        mBuilder.setView(viewInflated);


           mBuilder.setPositiveButton(R.string.txt_btn_postiveDialog, (dialog, which) -> {


           Limit = input.getText().toString();

               Navigation.findNavController(mContext , R.id.nav_host_fragment_activity_main).navigate(R.id.action_navigation_d_self);

        });

        mBuilder.setNegativeButton(R.string.txt_btn_negativeDialog, (dialog, which) -> dialog.cancel());


        return mBuilder.create();
    }


}
