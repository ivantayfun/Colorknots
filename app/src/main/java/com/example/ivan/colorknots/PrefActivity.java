package com.example.ivan.colorknots;

import android.os.Bundle;
import android.preference.PreferenceActivity;
public class PrefActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }


}