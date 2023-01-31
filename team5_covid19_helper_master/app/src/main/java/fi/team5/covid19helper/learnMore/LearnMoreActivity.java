package fi.team5.covid19helper.learnMore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import fi.team5.covid19helper.R;
import fi.team5.covid19helper.WhatWouldYouLikeToView;

/**
 * The class where it saves/remembers what button was selected in the age group activity
 * based on that shows what page to open when general information is selected
 */
public class LearnMoreActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     * Opened a SharedPreferences
     * Going to edit
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        SharedPreferences prefPut = getSharedPreferences("MyTestPref",MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();

        /*
         * Whichever button is picked, the assigned number is saved to know what general info age page to open
         * Under18 = 1
         * 18 to 44 = 2
         * etc.
         */

        Button under18Button = findViewById(R.id.under18Btn);
        under18Button.setOnClickListener(v -> {
        Intent under18 = new Intent(getApplicationContext(), WhatWouldYouLikeToView.class);
        prefEditor.putInt("ageGroup", 1);
        prefEditor.apply();
        startActivity(under18);
        });

        Button eighteenTo44Button = findViewById(R.id.age18_44Btn);
        eighteenTo44Button.setOnClickListener(v -> {
            Intent EighteenTo44 = new Intent(getApplicationContext(), WhatWouldYouLikeToView.class);
            prefEditor.putInt("ageGroup", 2);
            prefEditor.apply();
            startActivity(EighteenTo44);
        });

        Button fourtyfiveTo64Button = findViewById(R.id.age45_64Btn);
        fourtyfiveTo64Button.setOnClickListener(v -> {
            Intent fourtyfiveTo64 = new Intent(getApplicationContext(), WhatWouldYouLikeToView.class);
            prefEditor.putInt("ageGroup", 3);
            prefEditor.apply();
            startActivity(fourtyfiveTo64);
        });

        Button sixtyfiveAndAboveButton = findViewById(R.id.age65_aboveBtn);
        sixtyfiveAndAboveButton.setOnClickListener(v -> {
            Intent sixtyFiveAndAbove = new Intent(getApplicationContext(), WhatWouldYouLikeToView.class);
            prefEditor.putInt("ageGroup", 4);
            prefEditor.apply();
            startActivity(sixtyFiveAndAbove);
        });

        Button riskGroupButton = findViewById(R.id.riskGroupBtn);
        riskGroupButton.setOnClickListener(v -> {
            Intent riskGroup = new Intent(getApplicationContext(), WhatWouldYouLikeToView.class);
            prefEditor.putInt("ageGroup", 5);
            prefEditor.apply();
            startActivity(riskGroup);
        });
    }
}