package com.example.ivan.colorknots;

import android.os.Bundle;
import android.preference.PreferenceActivity;

//import com.example.myapplication.R;

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

    }
}