package com.example.android_examen_couckantoine.ui.other;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Utils.Utils;

import java.util.Locale;

public class PreferencesFragment extends PreferenceFragmentCompat {

    private FragmentActivity mContext;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity) context;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }


    @Override
    public void onResume() {

        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        String Languishes = prefs.getString("list_preference_1"  , "NL");

        if(Languishes.equals("NL")){

            //TODO change language to nl here
            Utils.updateResources(mContext , "NL");
        }
        if(Languishes.equals("ENG")){

            //TODO change language to eng here
            Utils.updateResources(mContext , "en" );
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        String Languishes = prefs.getString("list_preference_1"  , "NL");

        if(Languishes.equals("NL")){

            //TODO change language to nl here
            Utils.updateResources(mContext , "NL");
        }
        if(Languishes.equals("ENG")){
            //TODO change language to eng here
            Utils.updateResources(mContext , "en" );

        }

    }



}
