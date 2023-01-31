package fi.team5.covid19helper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import fi.team5.covid19helper.countryClasses.CountryFragment;

/**
 * Shows fragment in activity_current_status
 */
public class CurrentStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_status);

        //begin fragment transaction
        CountryFragment countryFragment = new CountryFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.countryFragment, countryFragment).commit();

    }
}