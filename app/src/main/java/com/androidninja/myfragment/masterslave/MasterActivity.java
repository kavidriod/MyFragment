package com.androidninja.myfragment.masterslave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.androidninja.myfragment.R;

public class MasterActivity extends AppCompatActivity implements FragmentActionListener{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String selectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.activity_main_portrait) != null)
        {
            if(savedInstanceState == null)
            {
                addCountriesFragment();
            }
            else
            {
                addCountryDescriptionFragment(savedInstanceState.getString("selectedCountry",null));
         // addCountryDescriptionFragment(R.id.fragmentContainer,null);
            }
        }
        else if(findViewById(R.id.activity_main_landscape) != null)
        {
          addCountriesFragment();
          if(savedInstanceState == null)
          {
              addCountryDescriptionFragment(R.id.fragmentContainer2,"India");
              //addCountryDescriptionFragment(R.id.fragmentContainer2,savedInstanceState.getString("selectedCountry","India"));
          }
          else
          {
              addCountryDescriptionFragment(R.id.fragmentContainer2,savedInstanceState.getString("selectedCountry",null));
              //addCountryDescriptionFragment(R.id.fragmentContainer2,null);
          }
        }
    }

    private void addCountriesFragment(){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryListFragment countryListFragment=new CountryListFragment();
        //countryListFragment.setCallBackInterface(this);
        countryListFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.fragmentContainer,countryListFragment);
        fragmentTransaction.commit();
    }

/*    private void addCountryDescriptionFragment(){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/

    private void addCountryDescriptionFragment(String countryName){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();

        Bundle bundle=new Bundle();
        bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY,countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(int fragmentContainerId, String countryName){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();


        Bundle bundle=new Bundle();
        bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY,countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(fragmentContainerId,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

/*
    private void addCountryDescriptionFragment(Bundle bundle) {
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();

        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
*/

  /*  @Override
    public void onActionPerformed(Bundle bundle) {
        int asctionPerfomred = bundle.getInt(ACTION_KEY);
        switch (asctionPerfomred)
        {
            case  FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED:
                selectedCountry = bundle.getString(KEY_SELECTED_COUNTRY,"India");
                addCountryDescriptionFragment(bundle);
        }
    }*/

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("selectedCountry",selectedCountry);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectedCountry = savedInstanceState.getString("selectedCountry","India");
    }

    /*  @Override
    public void callbackMethod() {
        addCountryDescriptionFragment();
    }
*/
    @Override
    public void countrySelected(String country) {
        selectedCountry = country;
        if(findViewById(R.id.activity_main_landscape) == null)
        {
            addCountryDescriptionFragment(country);
        }
        else
        { addCountryDescriptionFragment(R.id.fragmentContainer2,country);

        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){
            Log.i("OrintationChange", "landscape");

        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Log.i("OrintationChange", "portrait");
        }
    }
}