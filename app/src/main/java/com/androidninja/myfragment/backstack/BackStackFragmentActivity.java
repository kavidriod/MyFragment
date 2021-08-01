package com.androidninja.myfragment.backstack;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.androidninja.myfragment.DynamicFragment;
import com.androidninja.myfragment.R;

public class BackStackFragmentActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    TextView textViewfragmentcount;

    String TAG  = BackStackFragmentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bstack_fragment);

        fragmentManager = getSupportFragmentManager();;

        textViewfragmentcount = findViewById(R.id.textViewfragmentcount);
        textViewfragmentcount.setText("Fragment count in backstack: "+fragmentManager.getBackStackEntryCount());

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewfragmentcount.setText("Fragment count in backstack: "+fragmentManager.getBackStackEntryCount());

                StringBuilder backstackEntryMessage = new StringBuilder("Current status of fragment transaction back stack: "+fragmentManager.getBackStackEntryCount()+"\n");

                for(int index=(fragmentManager.getBackStackEntryCount()-1); index>=0; index--){
                    FragmentManager.BackStackEntry entry =  fragmentManager.getBackStackEntryAt(index);
                    backstackEntryMessage.append(entry.getName()+"\n");
                }
                Log.i(TAG,backstackEntryMessage.toString());
            }
        });



    }

    private void addFragment()
    {
        Fragment fragment;

      /*  switch (fragmentManager.getBackStackEntryCount())
        {
            case 0:fragment = new Fragment1();break;
            case 1:fragment = new Fragment2();break;
            case 2:fragment = new Fragment3();break;
            default:fragment = new Fragment1();break;
        }*/

        fragment = fragmentManager.findFragmentById(R.id.bstack_fragment_container);
        if(fragment instanceof Fragment1){
            fragment = new Fragment2();
        }else if(fragment instanceof Fragment2){
            fragment = new Fragment3();
        }else if(fragment instanceof Fragment3){
            fragment = new Fragment1();
        }else{
            fragment = new Fragment1();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bstack_fragment_container,fragment,"demofragment");
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.addToBackStack("Replace "+fragment.toString());
        fragmentTransaction.commit();
    }

    public void addFragment(View view) {
        addFragment();
    }


    @Override
    public void onBackPressed() {
        Fragment bStackFragment = fragmentManager.findFragmentById(R.id.bstack_fragment_container);
        if (bStackFragment != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            //fragmentTransaction.remove(bStackFragment);
            fragmentTransaction.addToBackStack("Remove "+bStackFragment.toString());
            fragmentTransaction.commit();
        } else {
            super.onBackPressed();
        }
    }
}