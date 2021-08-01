package com.androidninja.myfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        addFragment();
    }

    private void addFragment()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DynamicFragment dynamicFragment = new DynamicFragment();
        fragmentTransaction.add(R.id.dynamic_fragment_container,dynamicFragment);
        fragmentTransaction.commit();
    }
}