package com.example.android_examen_couckantoine.Utils;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;

import androidx.navigation.Navigation;

import com.example.android_examen_couckantoine.R;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class Utils {

    public static void updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

    }

    public static void ShowSnackbar(final Activity activity , View view){

        Snackbar snackbar = Snackbar.make(view.findViewById(R.id.dashboard_container) ,R.string.txt_snackbar_title , Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.GREEN);
        snackbar.setAction(R.string.txt_snackbar_apply, v -> Navigation.findNavController(activity , R.id.nav_host_fragment_activity_main).navigate(R.id.action_navigation_d_to_preferencesFragment22));
        snackbar.show();

    }


}
