package com.androidninja.myfragment.masterslave;

import android.os.Bundle;

public interface FragmentActionListener {

    String KEY_SELECTED_COUNTRY = "KEY_SELECTED_COUNTRY";
    void countrySelected(String country);

/*    String ACTION_KEY = "action_key";
    int ACTION_VALUE_COUNTRY_SELECTED = 1;

    void onActionPerformed(Bundle bundle);*/
}
