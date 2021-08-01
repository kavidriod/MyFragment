package com.androidninja.myfragment.masterslave;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.androidninja.myfragment.R;


public class CountryListFragment extends Fragment {

    View rootView;

    ListView listViewCountries;
    ArrayAdapter<String> countryNamesAdapter;
    Context context;
    String [] countries;

    //CallbackInterface callBackInterface;
    FragmentActionListener fragmentActionListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_country_list, container, false);
        initUI();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name)+"->Select Country");
    }

    private void initUI(){
        context  = getContext();
        countries = getResources().getStringArray(R.array.countries);
        listViewCountries = (ListView)rootView.findViewById(R.id.listViewCountries);

        countryNamesAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,countries);
        listViewCountries.setAdapter(countryNamesAdapter);

        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  /*  if(callBackInterface != null)
                    {
                        callBackInterface.callbackMethod();
                    }*/
                if(fragmentActionListener != null)
                {
                    fragmentActionListener.countrySelected(countries[i]);
                   /* Bundle bundle = new Bundle();
                    bundle.putInt(FragmentActionListener.ACTION_KEY,FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED);
                    bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY,countries[i]);
                    fragmentActionListener.onActionPerformed(bundle);*/
                }
            }
        });
    }

    /*public void setCallBackInterface(CallbackInterface callBackInterface)
    {
        this.callBackInterface = callBackInterface;
    }*/

    public void setFragmentActionListener(FragmentActionListener fragmentActionListener){
        this.fragmentActionListener = fragmentActionListener;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null)
        {
            fragmentActionListener = (FragmentActionListener) getActivity();
        }
    }
}