package com.androidninja.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LifeCycleFragment extends Fragment {

    private static final String COMMON_TAG = "LifeCycle";
    private static final String FRAGMENT_NAME = "Fragment";

    private static final String TAG = COMMON_TAG;

    public LifeCycleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, FRAGMENT_NAME +" onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, FRAGMENT_NAME +" onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, FRAGMENT_NAME +" onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lcycle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, FRAGMENT_NAME +" onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, FRAGMENT_NAME +" onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, FRAGMENT_NAME +" onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, FRAGMENT_NAME +" onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, FRAGMENT_NAME +" onStop");
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        Log.i(TAG, FRAGMENT_NAME +" onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, FRAGMENT_NAME +" onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, FRAGMENT_NAME +" onDetach");
        super.onDetach();
    }
}