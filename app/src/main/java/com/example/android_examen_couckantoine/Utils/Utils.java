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

    public static void ShowSandbar(final Activity activity , View view) {
        Snackbar snackbar = Snackbar.make(view, R.string.txt_toast_languages , Snackbar.LENGTH_LONG );
        snackbar.setActionTextColor(Color.GREEN);
        snackbar.setAction(R.string.txt_snackbarr_languages_btn, v -> Navigation.findNavController( activity , R.id.nav_host_fragment_activity_main).navigateUp());


        snackbar.show();
    }


}
