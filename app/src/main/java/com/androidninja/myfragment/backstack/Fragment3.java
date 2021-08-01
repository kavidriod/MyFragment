package com.androidninja.myfragment.backstack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.androidninja.myfragment.R;

public class Fragment3 extends Fragment {



    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment3, container, false);
    }


    @Override
    public String toString() {
        return Fragment3.class.getSimpleName();
    }
}