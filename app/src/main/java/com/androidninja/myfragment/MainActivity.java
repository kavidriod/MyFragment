package com.androidninja.myfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidninja.myfragment.backstack.BackStackFragmentActivity;
import com.androidninja.myfragment.backstack1.AddPopReplaceBackStackFragmentActivity;
import com.androidninja.myfragment.masterslave.MasterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchStaticFragment(View view) {
        Intent intent= new Intent(getApplicationContext(),StaticFragmentActivity.class);
        startActivity(intent);
    }

    public void launchDynamicFragment(View view) {
        Intent intent= new Intent(getApplicationContext(),DynamicFragmentActivity.class);
        startActivity(intent);
    }

    public void launchlifecycleFragment(View view) {
        Intent intent= new Intent(getApplicationContext(),LifeCycleFragmentActivity.class);
        startActivity(intent);
    }

    public void launchbackstackFragment(View view) {
        Intent intent= new Intent(getApplicationContext(), BackStackFragmentActivity.class);
        startActivity(intent);
    }

    public void launchAddPopRemoveFragment(View view) {
        Intent intent= new Intent(getApplicationContext(), AddPopReplaceBackStackFragmentActivity.class);
        startActivity(intent);
    }

    public void launchMasterSlaveFragment(View view) {
        Intent intent= new Intent(getApplicationContext(), MasterActivity.class);
        startActivity(intent);
    }
}