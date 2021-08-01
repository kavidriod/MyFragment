package com.androidninja.myfragment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LifeCycleFragmentActivity extends AppCompatActivity {

    private static final String COMMON_TAG = "LifeCycle";
    private static final String ACTIVITY_NAME = "Activity";
    private static final String TAG = COMMON_TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lcycle_fragment);
        addFragment();
        Log.i(TAG, ACTIVITY_NAME+" onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, ACTIVITY_NAME+" onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, ACTIVITY_NAME+" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, ACTIVITY_NAME+" onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, ACTIVITY_NAME+" onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, ACTIVITY_NAME+" onDestroy");
    }


    private void addFragment()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LifeCycleFragment lifeCycleFragment = new LifeCycleFragment();
        fragmentTransaction.add(R.id.lifecycle_fragment_container,lifeCycleFragment);
        fragmentTransaction.commit();
    }
}