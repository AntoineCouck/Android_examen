package com.example.android_examen_couckantoine.ui.other;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.example.android_examen_couckantoine.R;
import com.example.android_examen_couckantoine.Utils.Utils;


public class PreferencesFragment extends PreferenceFragmentCompat {

    private FragmentActivity mContext;
    SharedPreferences.OnSharedPreferenceChangeListener listener;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        listener = (prefs, key) -> {

            Utils.showSnackbar(mContext , getView());
        };
    }

    @Override
    public void onResume() {

        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        String Languishes = prefs.getString("list_preference_1"  , "");

        if(Languishes.equals("NL")){


            Utils.updateResources(mContext , "NL");
            prefs.registerOnSharedPreferenceChangeListener(listener);

        }
        if(Languishes.equals("ENG")){


            Utils.updateResources(mContext , "en" );
            prefs.registerOnSharedPreferenceChangeListener(listener);
        }
        if(Languishes.equals("FR")){


            Utils.updateResources(mContext , "fr" );
            prefs.registerOnSharedPreferenceChangeListener(listener);
        }


    }


    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        String Languishes = prefs.getString("list_preference_1"  , "NL");

        if(Languishes.equals("NL")){


            Utils.updateResources(mContext , "NL");
            prefs.registerOnSharedPreferenceChangeListener(listener);

        }
        if(Languishes.equals("ENG")){

            Utils.updateResources(mContext , "en" );
            prefs.registerOnSharedPreferenceChangeListener(listener);


        }
        if(Languishes.equals("FR")){


            Utils.updateResources(mContext , "fr" );
            prefs.registerOnSharedPreferenceChangeListener(listener);
        }

    }


}
